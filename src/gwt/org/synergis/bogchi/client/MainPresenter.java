package org.synergis.bogchi.client;

import org.enunes.gwt.mvp.client.presenter.Presenter;

public interface MainPresenter extends Presenter<MainPresenter.Display> {
	interface Display extends org.enunes.gwt.mvp.client.view.Display {
		
		void addMenu(org.enunes.gwt.mvp.client.view.Display display);
		
		void addContent(org.enunes.gwt.mvp.client.view.Display display);
		
		void removeContent();
	}
}
