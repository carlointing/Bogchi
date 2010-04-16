package org.synergis.bogchi.client;

import org.enunes.gwt.mvp.client.EventBus;
import org.enunes.gwt.mvp.client.presenter.BasePresenter;
import org.synergis.bogchi.client.AdminPagePresenter.Display;

import com.google.inject.Inject;

public class AdminPagePresenterImpl extends BasePresenter<Display> implements
		AdminPagePresenter {
	
	@Inject
	public AdminPagePresenterImpl(EventBus eventBus, Display display) {
		super(eventBus, display);		
	}

	@Override
	public void bind() {
		super.bind();

	}	

	@Override
	public void unbind() {
		super.unbind();
	}

}
