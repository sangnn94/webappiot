package vn.edu.uit.iot.editor;

import java.beans.PropertyEditorSupport;

import vn.edu.uit.iot.model.GatewayModel;
import vn.edu.uit.iot.model.UserModel;
import vn.edu.uit.iot.service.GatewayService;

public class GatewayEditor extends PropertyEditorSupport {
	private final UserModel user;

	public GatewayEditor(UserModel user) {
		// TODO Auto-generated constructor stub
		this.user = user;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		GatewayModel gateway = user.getGateways().get(text);
		setValue(gateway);
	}
}
