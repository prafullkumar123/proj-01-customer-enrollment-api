package com.citibank.enroll.customers.dao.impl;
import java.io.IOException;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.citibank.enroll.customers.email.EmailParamaters;
import com.citibank.enroll.customers.email.EnrollmentEmailNotification;
import com.citibank.enroll.customers.exception.BusinessException;
import com.citibank.enroll.customers.exception.SystemException;
import com.citibank.enroll.customers.model.EnrollmentDAOReq;
import com.citibank.enroll.customers.model.EnrollmentDAORes;

@Component
public class EnrollmentDAOImpl implements EnrollmentDAO{

	private Logger logger = Logger.getLogger(EnrollmentDAOImpl.class);
	EmailParamaters emailParams = new EmailParamaters();

	@Value("${sender-email-address}")
	private String fromAddress; 

	@Value("${sender-email-pass}")
	private String emailPass; 

	@Value("${email-service}")
	private boolean emailService; 

	public EnrollmentDAORes enroll(EnrollmentDAOReq daoReq) throws SystemException, BusinessException {
		
		logger.debug("Entered into EnrollmentDAOImpl");
		
		logger.info("EnrollmentDAOImpl  Request"+daoReq);
		
		String respCode = "0";
		
		String respMsg = "success";
		
		EnrollmentDAORes daoRes= null;
		
		try {
			if("0".equals(respCode)) {
		
				daoRes = new EnrollmentDAORes();
				
				daoRes.setDesc("sucess");
				
				daoRes.setRespMsg("good");
				
				daoRes.setStatus("delivered");
			
			}else if("101".equals(respCode) 
					||"102".equals(respCode) 
					||"103".equals(respCode) 
					||"104".equals(respCode) 
					||"105".equals(respCode)) {

				throw new BusinessException(respCode, respMsg);
			}
			else {
				throw new SystemException(respCode, respMsg);
			}
		} catch (BusinessException e1) {

			// TODO Auto-generated catch block
			logger.warn("BusinessException");
			throw e1;
		} catch (SystemException e1) {
		
			// TODO Auto-generated catch block
			logger.warn("SystemException");
			throw e1;
		}

		emailParams.setTo(daoReq.getEmail());
		
		emailParams.setFrom(fromAddress);
		
		emailParams.setUsername(fromAddress);
		
		emailParams.setPassword(emailPass);
		
		emailParams.setSubject("Message From O2 Service Provider");
		
		emailParams.setHtml(true);

		if(emailParams.getTo()!=null && !"".equals(emailParams.getTo()) && emailService == true ) {
		
			if ("good".equals(daoRes.getRespMsg())) {
				emailParams.setBodyContent("Thank you to subscribe our O2 Service  "
						+ "your cradit card :  XXXXXXXXXX"
						+(daoReq.getCardNo()).substring(daoReq.getCardNo().length()-4));
		
			}else {
			
				emailParams.setBodyContent("Sorry to inform you subscribtion has "
						+ "Failed our O2 Service  your cradit card :  XXXXXXXXXX"
						+(daoReq.getCardNo()).substring(daoReq.getCardNo().length()-4));
			
			}
			try {
				try {
			
					EnrollmentEmailNotification.sendEmail(emailParams);
				
				} catch (MessagingException e) {
				
					// TODO Auto-generated catch block
					logger.warn(e);
			
				}
			
			} catch (IOException e) {
				logger.warn(e);
			}
		}
		
		logger.debug("EnrollmentDAOImpl  Exit");

		return daoRes;
	
	}
}
