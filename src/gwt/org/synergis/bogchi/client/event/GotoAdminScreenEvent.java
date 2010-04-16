package org.synergis.bogchi.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GotoAdminScreenEvent extends GwtEvent<GotoAdminScreenHandler> {
	
	private static Type<GotoAdminScreenHandler> TYPE;
	
	public static Type<GotoAdminScreenHandler> getType() {
		return TYPE != null ? TYPE : (TYPE = new Type<GotoAdminScreenHandler>());
	}
	
	public GotoAdminScreenEvent() {
		// empty
	}
	
	@Override
	protected void dispatch(GotoAdminScreenHandler handler) {
		handler.onGotoAdminScreen(this);		
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<GotoAdminScreenHandler> getAssociatedType() {
		return getType();
	}

}
