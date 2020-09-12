package com.citibank.enroll.customers.email;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class EnrollmentEmailNotification {

	public static void sendEmail(EmailParamaters emailParamaters) throws IOException,
	AddressException, MessagingException{

		Properties prop = new Properties();

		InputStream input = null;

		input = new FileInputStream("src/main/resources/mail.properties");

		prop.load(input);

		Session session = Session.getInstance(prop,	new CustomAuthentication(
				emailParamaters.getUsername(), emailParamaters.getPassword()));

		// Create Message
		Message message = new MimeMessage(session);
		
		message.setFrom(getInternetaddress(emailParamaters.getFrom()));
		
		if (emailParamaters.getTo() != null && emailParamaters.getTo().contains(",")) {
			
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailParamaters.getTo()));
			
		} else {
			
			message.setRecipient(Message.RecipientType.TO, getInternetaddress(emailParamaters.getTo()));
			
		}
		
		if (emailParamaters.getCc() != null)
			message.setRecipient(Message.RecipientType.CC, getInternetaddress(emailParamaters.getCc()));
		
		if (emailParamaters.getBcc() != null)
			message.setRecipient(Message.RecipientType.BCC, getInternetaddress(emailParamaters.getBcc()));
		
		message.setSubject(emailParamaters.getSubject());

		if (emailParamaters.isHtml) 		
			message.setContent(emailParamaters.getBodyContent(), "text/html");
		 else 
			message.setText(emailParamaters.getBodyContent());

		// sending message
		Transport.send(message);

		System.out.println("Mail sent successfully");

	}

	private static InternetAddress getInternetaddress(String email) throws AddressException {
		
		return new InternetAddress(email);
		
	}
}
