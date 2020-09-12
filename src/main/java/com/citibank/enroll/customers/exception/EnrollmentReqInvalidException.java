package com.citibank.enroll.customers.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentReqInvalidException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String respCode;
	private String respMsg;
	
}
