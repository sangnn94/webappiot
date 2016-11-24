package vn.edu.uit.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.uit.iot.model.DataModel;

@RestController
public class RestfulController {
	@RequestMapping(value = "/postData", method = RequestMethod.POST)
	public ResponseEntity<String> postData(@RequestBody DataModel data) {
		System.out.println(data.getId());
		return new ResponseEntity<String>(data.getId(), HttpStatus.OK);
	}
}
