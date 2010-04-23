package org.synergis.bogchi.client;

import java.util.List;

import org.enunes.gwt.mvp.client.EventBus;
import org.enunes.gwt.mvp.client.presenter.BasePresenter;
import org.synergis.bogchi.client.dto.TaxonomyDTO;

import com.google.inject.Inject;

public class TaxonomyMaintenancePresenterImpl extends BasePresenter<TaxonomyMaintenancePresenter.Display>
		implements TaxonomyMaintenancePresenter {
	
	@Inject
	public TaxonomyMaintenancePresenterImpl(EventBus eventBus, Display display) {
		super(eventBus, display);		
	}

	@Override
	public void bind() {
		super.bind();

	}	

	@Override
	public void unbind() {
		super.bind();
	}

	@Override
	public void showTaxonomies(List<TaxonomyDTO> taxonomies) {
		display.getTaxonomies().setValue(taxonomies);		
	}

}
