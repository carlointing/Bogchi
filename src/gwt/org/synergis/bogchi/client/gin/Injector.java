package org.synergis.bogchi.client.gin;
import org.enunes.gwt.mvp.client.EventBus;
import org.synergis.bogchi.client.MainPresenter;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(Module.class)
public interface Injector extends Ginjector {
	
	MainPresenter getMainPresenter();
	
	EventBus getEventBus();
}
