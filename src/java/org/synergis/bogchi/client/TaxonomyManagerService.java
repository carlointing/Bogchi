package org.synergis.bogchi.client;

import com.google.gwt.user.client.rpc.RemoteService;

public interface TaxonomyManagerService extends RemoteService {
    /**
     * @gwt.typeArgs <org.synergis.bogchi.client.dto.TaxonomyDTO>
     */
    java.util.List listTaxonomies();
}
