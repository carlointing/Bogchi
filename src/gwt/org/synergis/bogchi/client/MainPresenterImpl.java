package org.synergis.bogchi.client;

import java.util.List;

import org.enunes.gwt.mvp.client.EventBus;
import org.enunes.gwt.mvp.client.presenter.BasePresenter;
import org.enunes.gwt.mvp.client.presenter.Presenter;
import org.synergis.bogchi.client.MainPresenter.Display;
import org.synergis.bogchi.client.dto.TaxonomyDTO;
import org.synergis.bogchi.client.event.DisplayTaxonomiesEvent;
import org.synergis.bogchi.client.event.DisplayTaxonomiesHandler;
import org.synergis.bogchi.client.event.GotoAdminScreenEvent;
import org.synergis.bogchi.client.event.GotoAdminScreenHandler;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class MainPresenterImpl extends BasePresenter<Display> implements
		MainPresenter {

	private final Provider<AdminPagePresenter> adminPageProvider;

	private final Provider<TaxonomyMaintenancePresenter> taxonomyMaintenanceProvider;

	private Presenter<? extends org.enunes.gwt.mvp.client.view.Display> presenter;

	@Inject
	public MainPresenterImpl(EventBus eventBus, Display display,
			Provider<AdminPagePresenter> adminPageProvider,
			Provider<TaxonomyMaintenancePresenter> taxonomyMaintenanceProvider,
			MenuPresenter menuPresenter) {
		super(eventBus, display);

		this.adminPageProvider = adminPageProvider;

		this.taxonomyMaintenanceProvider = taxonomyMaintenanceProvider;

		menuPresenter.bind();

		display.addMenu(menuPresenter.getDisplay());
	}

	@Override
	public void bind() {
		super.bind();

		registerHandler(eventBus.addHandler(GotoAdminScreenEvent.getType(),
				new GotoAdminScreenHandler() {

					@Override
					public void onGotoAdminScreen(GotoAdminScreenEvent event) {
						doGotoAdminScreen();
					}
				}));

		registerHandler(eventBus.addHandler(DisplayTaxonomiesEvent.getType(),
				new DisplayTaxonomiesHandler() {

					@Override
					public void onDisplayTaxonomies(DisplayTaxonomiesEvent event) {
						doDisplayTaxonomies(event.getTaxonomies());
					}
				}));

	}

	@Override
	public void unbind() {
		super.unbind();
		if (presenter != null) {
			presenter.unbind();
		}
	}

	private void doGotoAdminScreen() {
		final AdminPagePresenter adminPagePresenter = adminPageProvider.get();
		switchPresenter(adminPagePresenter);
	}

	private void doDisplayTaxonomies(List<TaxonomyDTO> taxonomies) {
		final TaxonomyMaintenancePresenter taxonomyMaintenancePresenter = taxonomyMaintenanceProvider
				.get();		
		switchPresenter(taxonomyMaintenancePresenter);
		taxonomyMaintenancePresenter.showTaxonomies(taxonomies);
	}

	private void switchPresenter(
			Presenter<? extends org.enunes.gwt.mvp.client.view.Display> presenter) {
		if (this.presenter != null) {
			this.presenter.unbind();
			display.removeContent();
		}

		this.presenter = presenter;

		if (presenter != null) {
			display.addContent(presenter.getDisplay());
			this.presenter.bind();
		}
	}
}
