package com.aa.eagleeye.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("common")
public class CommonConfig {
	
	private String eventHubName;
	
	private String eventHubconnectionString;

	public String getEventHubName() {
		return eventHubName;
	}

	public void setEventHubName(String eventHubName) {
		this.eventHubName = eventHubName;
	}

	public String getEventHubconnectionString() {
		return eventHubconnectionString;
	}

	public void setEventHubconnectionString(String eventHubconnectionString) {
		this.eventHubconnectionString = eventHubconnectionString;
	}
	
	

}
