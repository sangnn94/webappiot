package vn.edu.uit.iot.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import vn.edu.uit.iot.dao.UserDAO;
import vn.edu.uit.iot.model.UserModel;

public class UsernameExistValidator implements ConstraintValidator<UsernameExist, Object> {
	@Autowired
	private UserDAO userDao;

	@Override
	public void initialize(UsernameExist constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		String username = (String) value;
		UserModel user = userDao.findByUsername(username);
		if (user == null)
			return true;
		return false;
	}

}
