package com.citibank.enroll.customers.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class O2AuthServiceRes {

	private String respCode;
	private String respMsg;
	private String status;
	private boolean active;
}
