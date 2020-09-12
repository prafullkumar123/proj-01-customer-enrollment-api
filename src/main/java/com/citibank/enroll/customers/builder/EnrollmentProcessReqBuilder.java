package com.citibank.enroll.customers.builder;

import org.springframework.stereotype.Component;

import com.citibank.enroll.customers.model.CardverifyServicClientReq;
import com.citibank.enroll.customers.model.EnrollmentDAOReq;
import com.citibank.enroll.customers.model.EnrollmentProcessReq;

@Component
public class EnrollmentProcessReqBuilder {

	public CardverifyServicClientReq cardVerifyServiceReqBuild(EnrollmentProcessReq req) {
		
		CardverifyServicClientReq cardVerifyServiceReq = new CardverifyServicClientReq();
		
		cardVerifyServiceReq.setCardNo(req.getCardNo());
		
		cardVerifyServiceReq.setCvvNo(req.getCvvNo());
		
		cardVerifyServiceReq.setExpDate(req.getCvvNo());
		
		cardVerifyServiceReq.setNameOnCard(req.getNameOnCard());
		
		return cardVerifyServiceReq;
	}
	
	public EnrollmentDAOReq enrollDaoBuild(EnrollmentProcessReq req) {
		
		EnrollmentDAOReq enrolldaoReq = new EnrollmentDAOReq();
		
		enrolldaoReq.setClientId(req.getChannelId());
		
		enrolldaoReq.setCardNo(req.getCardNo());
		
		enrolldaoReq.setChannelId(req.getChannelId());
		
		enrolldaoReq.setCvvNo(req.getCvvNo());
		
		enrolldaoReq.setExpDate(req.getExpDate());
		
		enrolldaoReq.setMobileNo(req.getMobileNo());
		
		enrolldaoReq.setEmail(req.getEmail());
		
		enrolldaoReq.setNameOnCard(req.getNameOnCard());
		
		return enrolldaoReq;
	}
}
