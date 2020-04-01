package com.example.demo;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.LogDao;
import com.example.demo.vo.LogVo;


@Component
@Aspect
public class LoggingAspect {
	
	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	private void contMethod() {}
	
	@Autowired
	private LogDao dao;
	public void setDao(LogDao dao) {
		this.dao = dao;
	}

	@After("contMethod()")
	private void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		HttpServletRequest request = (HttpServletRequest)joinPoint.getArgs()[0];
		
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		String time = new Date().toLocaleString();
		
		LogVo vo = new LogVo();
		vo.setNo(dao.nextNo());
		vo.setUri(uri);
		vo.setIp(ip);
		vo.setTime(time);
		
		dao.insert(vo);
	}
}
