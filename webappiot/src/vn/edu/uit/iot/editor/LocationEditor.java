package vn.edu.uit.iot.editor;

import java.beans.PropertyEditorSupport;

import vn.edu.uit.iot.model.LocationModel;
import vn.edu.uit.iot.service.LocationService;

public class LocationEditor extends PropertyEditorSupport {
	private final LocationService locationService;

	public LocationEditor(LocationService locationService) {
		this.locationService = locationService;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		LocationModel location = locationService.get(Integer.parseInt(text));
		setValue(location);
	}
	
}
