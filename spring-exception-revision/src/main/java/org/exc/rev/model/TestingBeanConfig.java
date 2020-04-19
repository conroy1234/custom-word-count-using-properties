package org.exc.rev.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring-exception-revision")
public class TestingBeanConfig {

	private int maxnumber;
	private int minnumber;
	private String username;
	
	public int getMaxnumber() {
		return maxnumber;
	}
	public int getMinnumber() {
		return minnumber;
	}
	public void setMaxnumber(int maxnumber) {
		this.maxnumber = maxnumber;
	}
	public void setMinnumber(int minnumber) {
		this.minnumber = minnumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
