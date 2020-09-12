package com.citibank.enroll.customers.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.citibank.enroll.customers.model.EnrollmentProcessReq;
import com.citibank.enroll.customers.model.EnrollmentResourceReq;

@Component
public class EnrollmentResourceReqBuilder {

	public EnrollmentProcessReq buildProcessEnrollReq(EnrollmentResourceReq req) {
		
		final EnrollmentProcessReq enrollProcessReq = new EnrollmentProcessReq();
		
		enrollProcessReq.setCardNo(req.getCustInfo().getCardNo());
		
		enrollProcessReq.setChannelId(req.getClientContext().getChannelId());
		
		enrollProcessReq.setClientId(req.getClientContext().getClientId());
		
		enrollProcessReq.setCvvNo(req.getCustInfo().getCvvNo());
		
		enrollProcessReq.setExpDate(req.getCustInfo().getExpDate());
		
		final List<String> mobileList = new ArrayList<String>();
		
		for(String moNo : req.getCustInfo().getMobileNo()) {
			mobileList.add(moNo);
		}
		
		enrollProcessReq.setMobileNo(mobileList);
		
		enrollProcessReq.setEmail(req.getCustInfo().getEmail());
		
		enrollProcessReq.setNameOnCard(req.getCustInfo().getNameOnCard());
		
		enrollProcessReq.setClientId(req.getClientContext().getClientId());
		
		enrollProcessReq.setChannelId(req.getClientContext().getChannelId());
		
		return enrollProcessReq;
	}

}
