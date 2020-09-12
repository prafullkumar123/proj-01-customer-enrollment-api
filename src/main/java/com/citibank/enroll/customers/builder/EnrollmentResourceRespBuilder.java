/**
 * @author Manish kumar
 * @date
 */

package com.citibank.enroll.customers.builder;
import org.springframework.stereotype.Component;

import com.citibank.enroll.customers.model.EnrollmentProcessRes;
import com.citibank.enroll.customers.model.EnrollmentResourceReq;
import com.citibank.enroll.customers.model.EnrollmentResourceRes;
import com.citibank.enroll.customers.model.StatusBlock;

@Component
public class EnrollmentResourceRespBuilder {

	public EnrollmentResourceRes buildResourceEnrollResp(final EnrollmentProcessRes processResp, final EnrollmentResourceReq req) {

		EnrollmentResourceRes resourceRes = new EnrollmentResourceRes();

		final StatusBlock status = new StatusBlock();

		status.setRespCode(processResp.getRespCode());

		status.setRespMsg(processResp.getRespMsg());

		status.setStatus(processResp.getStatus());

		resourceRes.setStatus(status);

		return resourceRes;
	}
}
