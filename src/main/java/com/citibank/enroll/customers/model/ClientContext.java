package com.citibank.enroll.customers.model;

import lombok.Data;

@Data 
public class ClientContext {
	
	private String clientId;
	private String channelId;
	private String requestid;
	private String msgTimeStamp;
	
}
