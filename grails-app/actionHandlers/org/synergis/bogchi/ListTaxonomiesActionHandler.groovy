package org.synergis.bogchi

import org.synergis.bogchi.client.ListTaxonomiesAction
import org.synergis.bogchi.client.ListTaxonomiesResponse
import com.grailsrocks.taxonomy.Taxonomy;
import com.grailsrocks.taxonomy.TaxonomyService;
import org.synergis.bogchi.client.dto.TaxonomyDTO;

class ListTaxonomiesActionHandler {
    ListTaxonomiesResponse execute(ListTaxonomiesAction action) {
		def taxonomyList = Taxonomy.findAllByNameNotEqual(TaxonomyService.getGLOBAL_TAXONOMY_NAME())
		return new ListTaxonomiesResponse(taxonomyList.toDTO(TaxonomyDTO))
    }
}
