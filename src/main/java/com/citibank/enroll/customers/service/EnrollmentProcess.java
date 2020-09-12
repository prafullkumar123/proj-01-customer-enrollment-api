package com.citibank.enroll.customers.service;

import com.citibank.enroll.customers.exception.BusinessException;
import com.citibank.enroll.customers.exception.SystemException;
import com.citibank.enroll.customers.model.EnrollmentProcessReq;
import com.citibank.enroll.customers.model.EnrollmentProcessRes;

public interface EnrollmentProcess {
	
	EnrollmentProcessRes enroll(EnrollmentProcessReq req) throws SystemException, BusinessException, InterruptedException;

}
