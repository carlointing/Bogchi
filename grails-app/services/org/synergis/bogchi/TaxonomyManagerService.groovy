package org.synergis.bogchi

import java.util.List;
import org.codehaus.groovy.grails.plugins.gwt.annotation.CollectionTypeArg
import com.grailsrocks.taxonomy.Taxonomy;
import com.grailsrocks.taxonomy.TaxonomyService;
import org.synergis.bogchi.client.dto.TaxonomyDTO;;

class TaxonomyManagerService {

	static expose = ['gwt:org.synergis.bogchi.client']
	
	boolean transactional = true
	
	def taxonomyService
	
	@CollectionTypeArg(TaxonomyDTO)
	List listTaxonomies() {
		def taxonomyList = Taxonomy.findAllByNameNotEqual(TaxonomyService.GLOBAL_TAXONOMY_NAME)
		return taxonomyList.toDTO()
	}
}
