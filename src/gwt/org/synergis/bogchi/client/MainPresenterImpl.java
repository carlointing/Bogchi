package org.synergis.bogchi.client;

import org.enunes.gwt.mvp.client.EventBus;
import org.enunes.gwt.mvp.client.presenter.BasePresenter;
import org.enunes.gwt.mvp.client.presenter.Presenter;
import org.synergis.bogchi.client.MainPresenter.Display;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class MainPresenterImpl extends BasePresenter<Display> implements
		MainPresenter {
	
	private final Provider<AdminPagePresenter> adminPageProvider;	
	
	private Presenter<? extends org.enunes.gwt.mvp.client.view.Display> presenter;
	
	@Inject
	public MainPresenterImpl(EventBus eventBus, Display display,
			Provider<AdminPagePresenter> adminPageProvider,
			MenuPresenter menuPresenter) {
		super(eventBus, display);
		
		this.adminPageProvider = adminPageProvider;
		
		menuPresenter.bind();

		display.addMenu(menuPresenter.getDisplay());
	}

	@Override
	public void bind() {
		super.bind();

	}

	@Override
	public void unbind() {
		// TODO Auto-generated method stub

	}

}
