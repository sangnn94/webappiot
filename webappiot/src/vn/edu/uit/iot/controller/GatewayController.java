package vn.edu.uit.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.uit.iot.model.GatewayModel;
import vn.edu.uit.iot.model.GpsJson;
import vn.edu.uit.iot.service.GatewayService;

@Controller
public class GatewayController {
	@Autowired
	private GatewayService gatewayService;

	@RequestMapping(value = "/gps", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> postGps(@RequestBody GpsJson gps) {
		String id = gps.getId();
		GatewayModel gateway = gatewayService.get(id);
		if(gateway == null){
			// not found in database
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		String[] rawGps = gps.getGps().split(",");
		Float longitude = Float.parseFloat(rawGps[1]);
		Float latitude = Float.parseFloat(rawGps[2]);
		System.out.println(id + " " + longitude + " " + latitude);
		gateway.setLongitude(longitude);
		gateway.setLatitude(latitude);
		gatewayService.update(gateway);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
