package com.citibank.enroll.customers.builder;

import org.springframework.stereotype.Component;

import com.citibank.enroll.customers.model.EnrollmentDAORes;
import com.citibank.enroll.customers.model.EnrollmentProcessRes;

@Component
public class EnrollmentProcessRespBuilder {

	public EnrollmentProcessRes buildProcessResp(EnrollmentDAORes enrolldaoRes) {
		
		EnrollmentProcessRes processResp = new EnrollmentProcessRes();
		
		processResp.setRespCode(enrolldaoRes.getRespMsg());
		
		processResp.setRespMsg(enrolldaoRes.getRespMsg());
		
		processResp.setStatus(enrolldaoRes.getStatus());
		
		processResp.setDesc(enrolldaoRes.getDesc());
		
		return processResp;
	}

}
