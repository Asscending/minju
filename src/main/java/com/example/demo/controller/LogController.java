/*
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LogDao;
import com.example.demo.vo.LogVo;
import com.google.gson.Gson;

@RestController
public class LogController {
	
	@Autowired
	private LogDao dao;
	public void setDao(LogDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/listLog", produces = "application/json; charset=UTF-8")
	public String listAll(){
		String str = "";
		List<LogVo> list = dao.listAll();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}
	
	@RequestMapping("/insertLog")
	public String insert(LogVo vo) {
		String r="등록실패";
		int re = dao.insert(vo);
		if(re>0){
			r="등록성공";
		}
		return r;
	}
}
*/