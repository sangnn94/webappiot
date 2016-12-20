package vn.edu.uit.iot.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {
	private String exceptionMessage = "Invalid Url";
	private String duplicateUserMessage = "Username, email already exist, please login";

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
		return exceptionModelAndView(request, e, exceptionMessage);
	}

	private ModelAndView exceptionModelAndView(HttpServletRequest request, Exception e, String message) {
		e.printStackTrace();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModel().put("message", message);
		modelAndView.setViewName("exception");
		return modelAndView;
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ModelAndView duplicateUserHandler(HttpServletRequest request, Exception e) {
		return exceptionModelAndView(request, e, duplicateUserMessage);
	}
}
