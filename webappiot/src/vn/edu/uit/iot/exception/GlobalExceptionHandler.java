package vn.edu.uit.iot.exception;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	private String exceptionMessage = "Invalid Url";
	private String duplicateUserMessage = "Username, email already exist, please login";
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
		return exceptionModelAndView(request, e, exceptionMessage);
	}

	private ModelAndView exceptionModelAndView(HttpServletRequest request, Exception e, String message) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModel().put("message", message);
		modelAndView.getModel().put("url", request.getRequestURL());
		modelAndView.getModel().put("exception", e);
		modelAndView.setViewName("exception");
		return modelAndView;
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ModelAndView duplicateUserHandler(HttpServletRequest request, Exception e) {
		return exceptionModelAndView(request, e, duplicateUserMessage);
	}
}
