package com.atteam.atshop.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.atteam.atshop.model.MailInfo;
import com.atteam.atshop.service.IEmailService;

public class EmailServiceImpl implements IEmailService{
	
	@Autowired
	JavaMailSender sender;

	@Override
	public void send(MailInfo mail) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		helper.setFrom(mail.getFrom());
		helper.setTo(mail.getTo());
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getBody(), true);
		
		// gửi message đến SMTP server
		sender.send(message);
	}

	@Override
	public void send(String to, String subject, String body) throws MessagingException {
		this.send(new MailInfo(to, subject, body));
	}

//	@Override
//	public void sendEmail(ServletContext context, Account recipient, String type) {
//		String host = context.getInitParameter("host");
//		String port = context.getInitParameter("port");
//		String user = context.getInitParameter("user");
//		String pass = context.getInitParameter("pass");
//		try {
//			String content = null;
//			String subject = null;
//			switch(type) {
//				case "forgot":
//					subject = "New password";
//					content = "Dear " + recipient.getUserFullname() + ", your new password here: " + recipient.getPassword();
//					break;
//				default:
//					subject = "ATShop";
//					content = "Maybe this email is wrong, don't care about it";
//			}
//			SendEmailUtil.sendEmail(host, port, user, pass, recipient.getUserEmail(), subject, content);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
