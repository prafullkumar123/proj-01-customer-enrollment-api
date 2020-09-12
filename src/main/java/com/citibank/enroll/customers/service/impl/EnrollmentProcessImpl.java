package com.citibank.enroll.customers.service.impl;
import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citibank.enroll.customers.builder.EnrollmentProcessReqBuilder;
import com.citibank.enroll.customers.builder.EnrollmentProcessRespBuilder;
import com.citibank.enroll.customers.dao.impl.EnrollmentDAO;
import com.citibank.enroll.customers.exception.BusinessException;
import com.citibank.enroll.customers.exception.SystemException;
import com.citibank.enroll.customers.model.CardverifyServicClientReq;
import com.citibank.enroll.customers.model.CardverifyServicClientRes;
import com.citibank.enroll.customers.model.EnrollmentDAOReq;
import com.citibank.enroll.customers.model.EnrollmentDAORes;
import com.citibank.enroll.customers.model.EnrollmentProcessReq;
import com.citibank.enroll.customers.model.EnrollmentProcessRes;
import com.citibank.enroll.customers.service.CardverifyServicClient;
import com.citibank.enroll.customers.service.EnrollmentProcess;

@Component
public class EnrollmentProcessImpl implements EnrollmentProcess {

	private Logger logger = Logger.getLogger(EnrollmentProcessImpl.class);

	@Autowired
	private EnrollmentDAO enrolldao;

	@Autowired
	private EnrollmentProcessReqBuilder enrollmentProcessReqBuilder;

	@Autowired
	private CardverifyServicClient cardVerify;





	public EnrollmentProcessRes enroll(EnrollmentProcessReq req) throws SystemException, BusinessException{

		logger.info("Enter into Process  :: "+req);

		EnrollmentProcessRes processResp = null;
		ExecutorService svc = null;
		EnrollmentProcessReq enrollmentProcessReq = null;
		EnrollmentDAORes enrolldaoRes = null;
		EnrollmentProcessRespBuilder enrollmentProcessRespBuilder = new EnrollmentProcessRespBuilder();

		logger.debug("EnrollmentProcessImpl Request ");

		//prepare the cardVrifyTask object
		CardverifyServicClientReq cardVerifyServiceReq = enrollmentProcessReqBuilder.cardVerifyServiceReqBuild(req);

		CardverifyServicClientRes cardVerifyRespCode = cardVerify.enroll(cardVerifyServiceReq);

		if("0".equals(cardVerifyRespCode.getRespCode())) {

			EnrollmentDAOReq enrollmentDAOReq = enrollmentProcessReqBuilder.enrollDaoBuild(req);

			enrolldaoRes = enrolldao.enroll(enrollmentDAOReq);

		}else {

			logger.error("Invalid Card Details Please Check it !!");

		}
		processResp = enrollmentProcessRespBuilder.buildProcessResp(enrolldaoRes);

		logger.debug("Exit from Enrollment Process");

		return processResp;
	}

} 
