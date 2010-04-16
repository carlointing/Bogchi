package org.synergis.bogchi.client;

import org.synergis.bogchi.client.AdminPagePresenter.Display;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class AdminPageWidget extends Composite implements Display {
	
	private final FlowPanel panel;
	
	public AdminPageWidget() {
		panel = new FlowPanel();
		
		initWidget(panel);
		
		Label label = new Label("You're in the admin page");
		panel.add(label);
	}
	
	@Override
	public Widget asWidget() {		
		return this;
	}

}
