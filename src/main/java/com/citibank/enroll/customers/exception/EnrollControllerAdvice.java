package com.citibank.enroll.customers.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.citibank.enroll.customers.model.EnrollmentResourceRes;
import com.citibank.enroll.customers.model.StatusBlock;

@ControllerAdvice
public class EnrollControllerAdvice {

	@ExceptionHandler(EnrollmentReqInvalidException.class)
	private EnrollmentResourceRes enrollReqInvalid(EnrollmentReqInvalidException exe) {
		
		EnrollmentResourceRes exc = new EnrollmentResourceRes();
		final StatusBlock sb = new StatusBlock(exe.getRespCode(),exe.getRespMsg());
		
		exc.setStatus(sb);
		return exc;
	}
	@ExceptionHandler(SystemException.class)
	private EnrollmentResourceRes enrollSystem(SystemException exe) {
		
		EnrollmentResourceRes exc = new EnrollmentResourceRes();
		final StatusBlock sb = new StatusBlock(exe.getRespCode(),exe.getRespMsg());
		
		exc.setStatus(sb);
		return exc;
	}
	@ExceptionHandler(BusinessException.class)
	private EnrollmentResourceRes enrollBusiness(SystemException exe) {
		
		EnrollmentResourceRes exc = new EnrollmentResourceRes();
		final StatusBlock sb = new StatusBlock(exe.getRespCode(),exe.getRespMsg());
		
		exc.setStatus(sb);
		return exc;
	}
}
