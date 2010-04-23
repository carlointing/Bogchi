package org.synergis.bogchi.client;

import java.util.ArrayList;
import java.util.List;

import org.synergis.bogchi.client.TaxonomyMaintenancePresenter.Display;
import org.synergis.bogchi.client.dto.TaxonomyDTO;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class TaxonomyMaintenanceWidget extends Composite implements Display, HasValue<List<TaxonomyDTO>> {
	
	private final DockPanel panel;
	private final ListBox taxonomyListBox;
	
	private List<TaxonomyDTO> taxonomyList; 
	
	public TaxonomyMaintenanceWidget() {
		taxonomyList = new ArrayList<TaxonomyDTO>();		
		
		panel = new DockPanel();		
		initWidget(panel);
		
		Label label = new Label("List of Taxonomies");
		panel.add(label, DockPanel.NORTH);
		
		taxonomyListBox = new ListBox();
		panel.add(taxonomyListBox, DockPanel.CENTER);
	
		this.addValueChangeHandler(new ValueChangeHandler<List<TaxonomyDTO>>() {
			@Override
			public void onValueChange(ValueChangeEvent<List<TaxonomyDTO>> event) {
				taxonomyListBox.clear();
				for (TaxonomyDTO taxonomy : event.getValue()) {
					taxonomyListBox.addItem(taxonomy.getName());
				}
			}
		});
	
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
		if (!this.taxonomyList.equals(value)) {
			final List<TaxonomyDTO> oldValue = this.taxonomyList;			
			this.taxonomyList = value;
			ValueChangeEvent.<List<TaxonomyDTO>> fireIfNotEqual(this, oldValue, value);
		}
		
	}

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<List<TaxonomyDTO>> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

}
