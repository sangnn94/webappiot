package vn.edu.uit.iot.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(value={ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=GatewayIdExistValidator.class)
@Documented
public @interface GatewayIdExist {
	String message() default "This gateway already exist!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default{};
}
