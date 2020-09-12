package com.citibank.enroll.customers.model;

import lombok.Data;

@Data
public class EnrollmentResourceReq {

	private ClientContext clientContext;
	private CustmerInfo custInfo;
	private ServiceDetails serviceDetails;
	
}
