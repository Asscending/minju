package com.example.demo.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpDao;
import com.example.demo.vo.EmpVo;

@RestController
public class MailController {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private EmpDao dao;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}


	//@Scheduled(cron = "0 0 12 1 * ?")
	public void mailEmp() {
		List<EmpVo> list = dao.listEmp();
		for(EmpVo e : list) {
			System.out.println(e.getEmail());
			if( e.getEmail().equals("@") ) {
				continue;
			}
			mailSender.send(new MimeMessagePreparator() {
				@Override
				public void prepare(MimeMessage mimeMessage) throws MessagingException {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					message.setFrom("team.demo2020@gmail.com");
					message.setTo(e.getEmail());
				    message.setSubject("(주)Beat Company <급여 명세서>");
				    String str = "<h3>안녕하십니까, "+e.getEname()+" "+e.getJob()+"님.<h3>";
				    str += "<h3>(주)Beat Company입니다.</h3>";
				    str += "<h3>[ "+e.getEname()+" ]님의 이번 달 급여는 "+(e.getSal()+e.getComm())+"만원입니다</h3>";
				    str += "<h3>감사합니다.</h3>";
				    message.setText(str, true);
				}
			});
		}
	}
}
