package fr.assurance.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by Max on 05/04/2016.
 */
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "session")
public class ApplicationData {
    private String token;
    private Integer currentId;

	public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    public Integer getCurrentId() {
		return currentId;
	}

	public void setCurrentId(Integer currentId) {
		this.currentId = currentId;
	}
}
