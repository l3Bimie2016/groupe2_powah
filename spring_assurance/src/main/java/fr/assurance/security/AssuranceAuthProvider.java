package fr.assurance.security;

import java.util.ArrayList;

import fr.assurance.service.VertXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class AssuranceAuthProvider implements AuthenticationProvider{

	@Autowired
	private VertXService vertx;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		boolean isAuth = vertx.authenticate(username, password);
		if (!isAuth) return null;
		return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<GrantedAuthority>());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
