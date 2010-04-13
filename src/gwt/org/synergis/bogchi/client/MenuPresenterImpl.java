package org.synergis.bogchi.client;

import org.enunes.gwt.mvp.client.EventBus;
import org.enunes.gwt.mvp.client.presenter.BasePresenter;
import org.synergis.bogchi.client.MenuPresenter.Display;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;

public class MenuPresenterImpl extends BasePresenter<Display> implements
		MenuPresenter {

	@Inject
	public MenuPresenterImpl(EventBus eventBus, Display display) {
		super(eventBus, display);		
	}

	@Override
	public void bind() {
		super.bind();

		registerHandler(display.getAdminClickHandlers().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {

					}

				}));

	}	

}
