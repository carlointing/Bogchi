package org.synergis.bogchi.client;

import java.util.List;

import org.enunes.gwt.mvp.client.presenter.Presenter;
import org.synergis.bogchi.client.dto.TaxonomyDTO;
import com.google.gwt.user.client.ui.HasValue;

public interface TaxonomyMaintenancePresenter extends
		Presenter<TaxonomyMaintenancePresenter.Display> {
	
	interface Display extends org.enunes.gwt.mvp.client.view.Display {
		HasValue<List<TaxonomyDTO>> getTaxonomies();		
	}	
	
	void showTaxonomies(List<TaxonomyDTO> taxonomies);
	
}
