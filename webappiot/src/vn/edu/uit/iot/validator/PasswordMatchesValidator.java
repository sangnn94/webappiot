package vn.edu.uit.iot.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import vn.edu.uit.iot.model.UserModel;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>{

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		UserModel user = (UserModel) value;
		if(StringUtils.isEmpty(user.getMatchingPassword())){
			return false;
		}
		return user.getPassword().equals(user.getMatchingPassword());
	}

}
