package com.citibank.enroll.customers.email;

import lombok.Data;

@Data
public class EmailParamaters {
	
	public String from;
	public String to;
	public String subject;
	public String bodyContent;
	public String username;
	public String password;
	public boolean isHtml;
	public String cc;
	public String bcc;

}
