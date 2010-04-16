package org.synergis.bogchi.client.event;

import java.util.Collections;
import java.util.List;

import org.synergis.bogchi.client.dto.TaxonomyDTO;

import com.google.gwt.event.shared.GwtEvent;

public class DisplayTaxonomiesEvent extends GwtEvent<DisplayTaxonomiesHandler> {
	
	private static Type<DisplayTaxonomiesHandler> TYPE;
	
	private final List<TaxonomyDTO> taxonomyList;
	
	public static Type<DisplayTaxonomiesHandler> getType() {
		return TYPE != null ? TYPE : (TYPE = new Type<DisplayTaxonomiesHandler>());
	}
	
	public DisplayTaxonomiesEvent(List<TaxonomyDTO> taxonomyList) {
		this.taxonomyList = Collections.unmodifiableList(taxonomyList);
	}
	
	public List<TaxonomyDTO> getTaxonomies() {
		return taxonomyList;
	}
	
	@Override
	protected void dispatch(DisplayTaxonomiesHandler handler) {
		handler.onDisplayTaxonomies(this);		
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<DisplayTaxonomiesHandler> getAssociatedType() {
		return getType();
	}

}
