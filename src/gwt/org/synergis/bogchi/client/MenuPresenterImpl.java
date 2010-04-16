package org.synergis.bogchi.client;

import grails.plugins.gwt.client.GwtActionServiceAsync;

import java.util.List;

import org.enunes.gwt.mvp.client.EventBus;
import org.enunes.gwt.mvp.client.presenter.BasePresenter;
import org.synergis.bogchi.client.MenuPresenter.Display;
import org.synergis.bogchi.client.dto.TaxonomyDTO;
import org.synergis.bogchi.client.event.DisplayTaxonomiesEvent;
import org.synergis.bogchi.client.event.GotoAdminScreenEvent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class MenuPresenterImpl extends BasePresenter<Display> implements
		MenuPresenter {

	private final GwtActionServiceAsync gwtActionService;

	@Inject
	public MenuPresenterImpl(EventBus eventBus, Display display,
			GwtActionServiceAsync gwtActionService) {
		super(eventBus, display);
		this.gwtActionService = gwtActionService;
	}

	@Override
	public void bind() {
		super.bind();

		registerHandler(display.getGotoAdminScreenClickHandlers()
				.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						eventBus.fireEvent(new GotoAdminScreenEvent());
					}

				}));

		registerHandler(display.getTaxonomyMaintenanceClickHandlers()
				.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						gwtActionService.execute(new ListTaxonomiesAction(), new AsyncCallback<ListTaxonomiesResponse>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Error retrieving taxonomies");
							}

							@Override
							public void onSuccess(ListTaxonomiesResponse result) {
								List<TaxonomyDTO> taxonomies = result.getTaxonomyList();
								eventBus.fireEvent(new DisplayTaxonomiesEvent(taxonomies));
							}
						});
					}

				}));

	}

}
