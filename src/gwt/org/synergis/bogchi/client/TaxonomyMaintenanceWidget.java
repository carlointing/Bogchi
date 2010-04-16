package org.synergis.bogchi.client;

import java.util.ArrayList;
import java.util.List;

import org.synergis.bogchi.client.TaxonomyMaintenancePresenter.Display;
import org.synergis.bogchi.client.dto.TaxonomyDTO;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

public class TaxonomyMaintenanceWidget extends Composite implements Display, HasValue<List<TaxonomyDTO>> {
	
	private final Panel panel;
	private final ListBox taxonomyListBox;
	
	private List<TaxonomyDTO> taxonomyList; 
	
	public TaxonomyMaintenanceWidget() {
		panel = new DockPanel();
		
		initWidget(panel);		
		taxonomyListBox = new ListBox();
		panel.add(taxonomyListBox);
		
		taxonomyList = new ArrayList<TaxonomyDTO>();
	}
	
	@Override
	public HasValue<List<TaxonomyDTO>> getTaxonomies() {
		return this;
	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public List<TaxonomyDTO> getValue() {
		return new ArrayList<TaxonomyDTO>(taxonomyList);
	}

	@Override
	public void setValue(List<TaxonomyDTO> value) {
		setValue(value, true);		
	}

	@Override
	public void setValue(List<TaxonomyDTO> value, boolean fireEvents) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<List<TaxonomyDTO>> handler) {
		// TODO Auto-generated method stub
		return null;
	}

}
