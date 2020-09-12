package com.citibank.enroll.customers.svcclient.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.citibank.enroll.customers.model.CardverifyServicClientReq;
import com.citibank.enroll.customers.model.CardverifyServicClientRes;
import com.citibank.enroll.customers.service.CardverifyServicClient;

@Component
public class CardverifyServicClientImpl  implements CardverifyServicClient{

	private Logger logger = Logger.getLogger(CardverifyServicClientImpl.class);
	
	public CardverifyServicClientRes enroll(CardverifyServicClientReq req) {
	
		// TODO Auto-generated method stub
		logger.info("Entered into Card Verify service "+req);
		
		logger.debug("CardverifyServicClientImpl  Request ");
		
		CardverifyServicClientRes resCardVarify = new CardverifyServicClientRes();
		
		resCardVarify.setActive(true);
		
		resCardVarify.setRespCode("0");
		
		resCardVarify.setRespMsg("sucees");
		
		resCardVarify.setStatus("valid");
		
		logger.debug("CardverifyServicClientImpl  Exit");
		
		return resCardVarify;
	}
}
