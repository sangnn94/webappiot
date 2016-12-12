package vn.edu.uit.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.edu.uit.iot.model.GatewayModel;
import vn.edu.uit.iot.service.GatewayService;

@Controller
public class GatewayController {
	@Autowired
	private GatewayService gatewayService;
	
	@RequestMapping(value="/post-gps", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> postGps(@RequestBody GatewayModel gateway){
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
