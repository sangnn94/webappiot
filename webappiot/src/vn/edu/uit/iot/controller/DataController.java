package vn.edu.uit.iot.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import vn.edu.uit.iot.model.AirModel;
import vn.edu.uit.iot.model.DataJson;
import vn.edu.uit.iot.model.DataModel;
import vn.edu.uit.iot.model.NodeModel;
import vn.edu.uit.iot.model.Value;
import vn.edu.uit.iot.model.ValueModel;
import vn.edu.uit.iot.service.AirService;
import vn.edu.uit.iot.service.DataService;
import vn.edu.uit.iot.service.NodeService;

@Controller
public class DataController {
	@Autowired
	private NodeService nodeService;
	@Autowired
	private AirService airService;
	@Autowired
	private DataService dataService;

	@RequestMapping(value = "/data", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> postData(@RequestBody DataJson data) {
		String id = data.getId();
		NodeModel node = nodeService.get(id);
		if (node == null) {
			// not found node in database
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		DataModel dataModel = new DataModel(node); // get data relation with a node
		Set<Value> values = data.getDatas();
		Set<ValueModel> valueModels = new HashSet<>();
		for (Value value : values) {
			AirModel air = airService.get(value.getId());
			if (air == null) {
				continue;
			}
			ValueModel valueModel = new ValueModel(air, value.getValue());
			valueModel.setData(dataModel); // set parent of data to value
			valueModels.add(valueModel); // add to set of value
		}
		dataModel.setValue(valueModels); // add set to data record
		dataService.insert(dataModel);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
