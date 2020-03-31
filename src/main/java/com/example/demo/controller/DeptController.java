package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.DeptVo;
@RestController
public class DeptController {
//	DeptDao dao = new DeptDao();
	@RequestMapping("/insertDept")
	public String insertDept(DeptVo d) {
		String r="등록실패";
/*		int re=dao.insert(d);
		if(re>0) {
			r="등록성공";
		}*/
		return r;
	}
	
	@RequestMapping("/listDept")
	public String listDept() {
		String r="";
/*		List<DeptVo> list = dao.list();
		r = new Gson().toJson(list);*/
		return r;
	}
}
