package com.citibank.enroll.customers.model;

import lombok.Data;

@Data
public class CardverifyServicClientReq {

	private String cardNo;
	private String cvvNo;
	private String expDate;
	private String nameOnCard;
	
}
