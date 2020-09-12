package com.citibank.enroll.customers.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citibank.enroll.customers.builder.EnrollmentResourceReqBuilder;
import com.citibank.enroll.customers.builder.EnrollmentResourceRespBuilder;
import com.citibank.enroll.customers.exception.BusinessException;
import com.citibank.enroll.customers.exception.EnrollmentReqInvalidException;
import com.citibank.enroll.customers.exception.SystemException;
import com.citibank.enroll.customers.model.EnrollmentProcessReq;
import com.citibank.enroll.customers.model.EnrollmentProcessRes;
import com.citibank.enroll.customers.model.EnrollmentResourceReq;
import com.citibank.enroll.customers.model.EnrollmentResourceRes;
import com.citibank.enroll.customers.model.StatusBlock;
import com.citibank.enroll.customers.service.EnrollmentProcess;
import com.citibank.enroll.customers.validator.EnrollmentReqValidator;

@RestController
@RequestMapping("/v2")
public class EnrollmentController {

	@Autowired
	private EnrollmentReqValidator validator;

	@Autowired
	private EnrollmentResourceReqBuilder enrollmentResourceReqBuilder;

	@Autowired
	private EnrollmentResourceRespBuilder respBuilder;

	@Autowired
	EnrollmentProcess enrollProcess;

	private  Logger logger = Logger.getLogger(EnrollmentController.class); 

	/**
	 * @param enrollReq
	 * @return This method will enroll the user after data varification
	 * @throws InterruptedException 
	 * @throws BusinessException 
	 * @throws SystemException 
	 * @throws EnrollmentReqInvalidException 
	 */
	@PostMapping("/enrollment")
	public @ResponseBody EnrollmentResourceRes enroll(@RequestBody EnrollmentResourceReq enrollReq) throws InterruptedException {

		logger.info("Entered into Resouce Layer :: "+enrollReq);

		EnrollmentResourceRes resourceRes = null;
		
		try {
			
			// validate the request
			validator.validateRequest(enrollReq);

			EnrollmentProcessReq  enrollProcessReq = enrollmentResourceReqBuilder.buildProcessEnrollReq(enrollReq);

			final EnrollmentProcessRes enrollProcessRes = enrollProcess.enroll(enrollProcessReq);

			resourceRes = respBuilder.buildResourceEnrollResp(enrollProcessRes, enrollReq);

		} catch (EnrollmentReqInvalidException exe) {
		
			// TODO Auto-generated catch block
			resourceRes = new EnrollmentResourceRes();
			
			final StatusBlock sb = new StatusBlock(exe.getRespCode(),exe.getRespMsg());
			
			resourceRes.setStatus(sb);

		}
		catch (SystemException exe) {
			
			// TODO Auto-generated catch block
			resourceRes = new EnrollmentResourceRes();
			
			final StatusBlock sb = new StatusBlock(exe.getRespCode(),exe.getRespMsg());
			
			resourceRes.setStatus(sb);
		}
		catch (BusinessException exe) {
			
			// TODO Auto-generated catch block
			resourceRes = new EnrollmentResourceRes();
			
			final StatusBlock sb = new StatusBlock(exe.getRespCode(),exe.getRespMsg());
			
			resourceRes.setStatus(sb);
		}

		logger.info("Exit From Resouce Layer :: "+resourceRes);
		
		return  resourceRes;
	}

}
