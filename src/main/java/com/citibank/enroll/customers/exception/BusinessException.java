package com.citibank.enroll.customers.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends Exception {
	
	/**
	 * @author 
	 *
	 * @Description :
	 */
	private static final long serialVersionUID = 1L;
	private String respCode;
	private String respMsg;
}
