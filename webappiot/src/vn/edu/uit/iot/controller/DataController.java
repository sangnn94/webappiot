package vn.edu.uit.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import vn.edu.uit.iot.model.DataJson;
import vn.edu.uit.iot.model.DataModel;

@Controller
public class DataController {
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> postData(@RequestBody DataJson data) {
		System.out.println(data);
		return new ResponseEntity<Void>( HttpStatus.OK);
	}
}
