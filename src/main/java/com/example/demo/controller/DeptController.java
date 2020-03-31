package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DeptDao;
import com.example.demo.vo.DeptVo;
import com.google.gson.Gson;
@RestController
public class DeptController {
	
	@Autowired
	private DeptDao dao;
	
	public void setDao(DeptDao dao) {
		this.dao = dao;
		
	}

	@RequestMapping("/insertDept")
	public String insertDept(DeptVo d) {
		String r="등록실패";
		int re=dao.insertDept(d);
		if(re>0) {
			r="등록성공";
		}
		return r;
	}
	
	@RequestMapping("/listDept")
	public String listDept() {
		String r="";
		List<DeptVo> list = dao.listDept();
		r = new Gson().toJson(list);
		return r;
	}
}
