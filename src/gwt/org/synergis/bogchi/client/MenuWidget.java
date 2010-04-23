package org.synergis.bogchi.client;

import org.synergis.bogchi.client.MenuPresenter.Display;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;

public class MenuWidget extends Composite implements Display {
	
	private final Hyperlink gotoAdminScreenLink;
	
	private final Hyperlink taxonomyMaintenanceLink;
	
	public MenuWidget() {
		final HorizontalPanel panel = new HorizontalPanel();		
		initWidget(panel);
		
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		
		gotoAdminScreenLink = new Hyperlink("Admin", "admin");
		taxonomyMaintenanceLink = new Hyperlink("Taxonomies", "taxonomies");
				
		panel.add(gotoAdminScreenLink);
		panel.add(taxonomyMaintenanceLink);
	}
	
	@Override
	public HasClickHandlers getGotoAdminScreenClickHandlers() {
		return gotoAdminScreenLink;
	}

	@Override
	public Widget asWidget() {		
		return this;
	}

	@Override
	public HasClickHandlers getTaxonomyMaintenanceClickHandlers() {
		return taxonomyMaintenanceLink;
	}

}
