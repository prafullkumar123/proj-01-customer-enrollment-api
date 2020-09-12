package com.citibank.enroll.customers.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskResult {

	private String taskName;
	private Object result;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaskResult [taskName=");
		builder.append(taskName);
		builder.append(", result=");
		builder.append(result);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
