package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpDao;
import com.example.demo.vo.EmpVo;
import com.google.gson.Gson;

@RestController
public class EmpController {
	
	@Autowired
	private EmpDao dao;

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value="/listEmp", produces = "application/json;charset=UTF-8")
	public String listEmp() {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.listEmp());
		return str;
	}
	
	@RequestMapping(value="/detailEmp", produces = "application/json;charset=UTF-8")
	public String detailEmp(EmpVo e) {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.detailEmp(e));
		return str;
	}
	
	@RequestMapping("/insertEmp")
	public String insertEmp(EmpVo e) {
		String str = "사원 등록에 실패했습니다.";

		e.setEno(dao.nextEno());
		int re = dao.insertEmp(e);
		if( re > 0 ) {
			str = "사원 등록에 성공했습니다.";
		}

		return str;
	}
	
	@RequestMapping("/updateEmp")
	public String updateEmp(EmpVo e) {
		String str = "사원 정보 수정에 실패했습니다.";
		
		int re = dao.updateEmp(e);
		if( re > 0 ) {
			str = "사원 정보 수정에 성공했습니다.";
		}
		
		return str;
	}
	
	@RequestMapping("/deleteEmp")
	public String deleteEmp(EmpVo e) {
		String str = "사원 정보 삭제에 실패했습니다.";
		
		int re = dao.deleteEmp(e);
		if( re > 0 ) {
			str = "사원 삭제에 성공했습니다.";
		}
		
		return str;
	}
	
}
