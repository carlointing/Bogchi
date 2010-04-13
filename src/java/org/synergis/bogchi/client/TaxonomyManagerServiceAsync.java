package org.synergis.bogchi.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TaxonomyManagerServiceAsync {
    void listTaxonomies(AsyncCallback callback);
}
