package com.citibank.enroll.customers.service;

import com.citibank.enroll.customers.model.CardverifyServicClientReq;
import com.citibank.enroll.customers.model.CardverifyServicClientRes;

public interface CardverifyServicClient {
	
	CardverifyServicClientRes enroll(CardverifyServicClientReq req);

}
