package org.synergis.bogchi.client;

import org.synergis.bogchi.client.MainPresenter.Display;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainWidget extends Composite implements Display {
	
	private final DockPanel panel;
	private Widget content;
	
	public MainWidget() {
		panel = new DockPanel();
		initWidget(panel);
	}
	
	@Override
	public void addContent(org.enunes.gwt.mvp.client.view.Display display) {
		removeContent();
		content = display.asWidget();
		panel.add(content, DockPanel.CENTER);
	}

	@Override
	public void addMenu(org.enunes.gwt.mvp.client.view.Display display) {
		panel.add(display.asWidget(), DockPanel.NORTH);
	}

	@Override
	public void removeContent() {
		if (content != null) {
			panel.remove(content);
		}
	}

	@Override
	public Widget asWidget() {		
		return this;
	}

}
