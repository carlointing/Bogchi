package org.synergis.bogchi.client.gin;

import com.google.gwt.inject.client.AbstractGinModule;

public class Module extends AbstractGinModule {

	@Override
	protected void configure() {
		install(new org.enunes.gwt.mvp.client.gin.Module());

	}

}
