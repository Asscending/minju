package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.EmpManager;
import com.example.demo.vo.EmpVo;

@Repository
public class EmpDao {
	
	public List<EmpVo> listEmp(){
		return EmpManager.listEmp(); 
	}
	
	public EmpVo detailEmp(EmpVo v) {
		return EmpManager.detailEmp(v);
	}
	
	public int nextEno() {
		return EmpManager.nextEno();
	}
	
	public int insertEmp(EmpVo v) {
		return EmpManager.insertEmp(v);
	}
	
	public int updateEmp(EmpVo v) {
		return EmpManager.updateEmp(v);
	}
	
	public int deleteEmp(EmpVo v) {
		return EmpManager.deleteEmp(v);
	}
}
