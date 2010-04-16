package org.synergis.bogchi.client;

import org.enunes.gwt.mvp.client.presenter.Presenter;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface MenuPresenter extends Presenter<MenuPresenter.Display> {
	interface Display extends org.enunes.gwt.mvp.client.view.Display {
		HasClickHandlers getGotoAdminScreenClickHandlers();
		
		HasClickHandlers getTaxonomyMaintenanceClickHandlers();
	}
}
