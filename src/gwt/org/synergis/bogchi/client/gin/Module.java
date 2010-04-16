package org.synergis.bogchi.client.gin;

import grails.plugins.gwt.client.GwtActionService;
import grails.plugins.gwt.client.GwtActionServiceAsync;

import org.synergis.bogchi.client.AdminPagePresenter;
import org.synergis.bogchi.client.AdminPagePresenterImpl;
import org.synergis.bogchi.client.AdminPageWidget;
import org.synergis.bogchi.client.MainPresenter;
import org.synergis.bogchi.client.MainPresenterImpl;
import org.synergis.bogchi.client.MainWidget;
import org.synergis.bogchi.client.MenuPresenter;
import org.synergis.bogchi.client.MenuPresenterImpl;
import org.synergis.bogchi.client.MenuWidget;
import org.synergis.bogchi.client.TaxonomyMaintenancePresenter;
import org.synergis.bogchi.client.TaxonomyMaintenancePresenterImpl;
import org.synergis.bogchi.client.TaxonomyMaintenanceWidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class Module extends AbstractGinModule {

	@Override
	protected void configure() {
		install(new org.enunes.gwt.mvp.client.gin.Module());

		bind(AdminPagePresenter.class).to(AdminPagePresenterImpl.class);
		bind(AdminPagePresenter.Display.class).to(AdminPageWidget.class);
		
		bind(TaxonomyMaintenancePresenter.class).to(TaxonomyMaintenancePresenterImpl.class);
		bind(TaxonomyMaintenancePresenter.Display.class).to(TaxonomyMaintenanceWidget.class);
		
		bind(MenuPresenter.class).to(MenuPresenterImpl.class);
		bind(MenuPresenter.Display.class).to(MenuWidget.class);

		bind(MainPresenter.class).to(MainPresenterImpl.class);
		bind(MainPresenter.Display.class).to(MainWidget.class);
	}
	
	@Provides @Singleton
	GwtActionServiceAsync provideGwtActionService() {
		GwtActionServiceAsync service = GWT.create(GwtActionService.class);
		((ServiceDefTarget) service).setServiceEntryPoint(GWT
				.getModuleBaseURL()
				+ "rpc");
		return service;
	}

}
