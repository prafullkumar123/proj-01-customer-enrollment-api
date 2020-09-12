package com.citibank.enroll.customers.validator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.citibank.enroll.customers.exception.EnrollmentReqInvalidException;
import com.citibank.enroll.customers.model.ClientContext;
import com.citibank.enroll.customers.model.EnrollmentResourceReq;

/**
 * @author Manish kumar
 * TODO : This class is used  to validate upcoming request 
 */
@Component
public class EnrollmentReqValidator  {
	 
	private Logger logger = Logger.getLogger(EnrollmentReqValidator.class);

	public void validateRequest(EnrollmentResourceReq req)  throws EnrollmentReqInvalidException {
		//TODO: validate the request : if the request is valid don't return anything
		
		//if the request is invalid then handle user defined exception and throws the exception
		if(req == null || req.getClientContext() == null || req.getCustInfo() == null) {
			
			logger.error("Entered into request obj null if");
			
			throw new EnrollmentReqInvalidException("err001", "request object is null or empty");
		}
		
		ClientContext clientContext = req.getClientContext();
		
		if(clientContext.getClientId() == null || "".equals(clientContext.getClientId())) {
		
			throw new EnrollmentReqInvalidException("err002", "client is invalid");
		}
		
		if(clientContext.getChannelId() == null || "".equals(clientContext.getChannelId())) {
		
			throw new EnrollmentReqInvalidException("err003", "channel is invalid");			
		}
		
		//TODO: need to write validations for all the required elements

	}
}
