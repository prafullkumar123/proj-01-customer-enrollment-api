package com.citibank.enroll.customers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class StatusBlock {

	@NonNull
	private String respCode;
	@NonNull
	private String respMsg;
	private String status;
	
}
