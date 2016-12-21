package vn.edu.uit.iot.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import vn.edu.uit.iot.dao.GatewayDAO;
import vn.edu.uit.iot.model.GatewayModel;

public class GatewayIdExistValidator implements ConstraintValidator<GatewayIdExist, String> {
	
	@Autowired
	private GatewayDAO gatewayDao;
	@Override
	public void initialize(GatewayIdExist constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String id, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		GatewayModel gateway = gatewayDao.get(id);
		if(gateway == null){
			return true;
		}
		return false;
	}

}
