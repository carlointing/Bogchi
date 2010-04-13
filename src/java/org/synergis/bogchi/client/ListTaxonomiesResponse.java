package org.synergis.bogchi.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.synergis.bogchi.client.dto.TaxonomyDTO;

import grails.plugins.gwt.shared.Response;

public class ListTaxonomiesResponse implements Response {
    private static final long serialVersionUID = 1L;

    private List<TaxonomyDTO> taxonomyList = new ArrayList<TaxonomyDTO>();
    
    @SuppressWarnings("unused")
	private ListTaxonomiesResponse() {}
    
    public ListTaxonomiesResponse(List<TaxonomyDTO> result) {
    	this.taxonomyList.addAll(result);
    }
    
    public List<TaxonomyDTO> getTaxonomyList() {
    	return Collections.unmodifiableList(this.taxonomyList);
    }
}
