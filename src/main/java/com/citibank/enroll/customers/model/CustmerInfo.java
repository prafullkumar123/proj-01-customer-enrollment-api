package com.citibank.enroll.customers.model;

import java.util.List;

import lombok.Data;

@Data
public class CustmerInfo {
	
	private List<String> mobileNo;
	private String email;
	private String cardNo;
	private String cvvNo;
	private String expDate;
	private String nameOnCard;

}
