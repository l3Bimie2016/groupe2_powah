package fr.assurance.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fr.assurance.bean.ApplicationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Service
public class AssuranceAuthProvider implements AuthenticationProvider{

	@Autowired
	private ApplicationData appData;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		final String uri = "http://localhost:8090/login";
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("username", username);
		data.put("password", password);
		
		String request = new Gson().toJson(data);
		
		HttpEntity<String> entity = new HttpEntity<>(request, header);
		
		RestTemplate restTemplate = new RestTemplate();

		String response = restTemplate.postForObject(uri, entity, String.class);
		System.out.println(response);
		
		appData.setToken(response);
		return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<GrantedAuthority>());
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
