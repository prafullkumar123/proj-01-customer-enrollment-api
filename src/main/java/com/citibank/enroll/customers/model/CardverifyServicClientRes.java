package com.citibank.enroll.customers.model;

import lombok.Data;

@Data
public class CardverifyServicClientRes {
	
	private String respCode;
	private String respMsg;
	private String status;
	private boolean active;

}
