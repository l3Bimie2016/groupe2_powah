package fr.assurance.security;

import java.util.ArrayList;

import fr.assurance.bean.ApplicationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AssuranceAuthProvider implements AuthenticationProvider{

	@Autowired
	private ApplicationData appData;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		appData.setToken("");
		return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<GrantedAuthority>());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
