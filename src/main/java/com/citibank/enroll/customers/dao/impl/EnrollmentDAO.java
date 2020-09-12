package com.citibank.enroll.customers.dao.impl;

import com.citibank.enroll.customers.exception.BusinessException;
import com.citibank.enroll.customers.exception.SystemException;
import com.citibank.enroll.customers.model.EnrollmentDAOReq;
import com.citibank.enroll.customers.model.EnrollmentDAORes;

public interface EnrollmentDAO {

	EnrollmentDAORes enroll(EnrollmentDAOReq req) throws SystemException, BusinessException;

}
