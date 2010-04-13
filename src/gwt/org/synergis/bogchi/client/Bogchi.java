package org.synergis.bogchi.client;

import org.enunes.gwt.mvp.client.EventBus;
import org.synergis.bogchi.client.gin.Injector;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Bogchi implements EntryPoint {
	
	/**
     * This is the entry point method.
     */
    public void onModuleLoad() {
    	
    	final Injector ginjector = GWT.create(Injector.class);
    	
    	final MainPresenter mainPresenter = ginjector.getMainPresenter();
    	
    	mainPresenter.bind();
    	
    	RootPanel.get().add(mainPresenter.getDisplay().asWidget());
    	
    	logEvent(ginjector.getEventBus());
    
    }
    
    private void logEvent(EventBus eventBus) {
    	
    }
    
}
