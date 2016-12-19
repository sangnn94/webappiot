package vn.edu.uit.iot.authentication;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacadeInterface {
	Authentication getAuthentication();
}
