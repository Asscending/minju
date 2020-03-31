package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DeptManager;
import com.example.demo.vo.DeptVo;

@Repository
public class DeptDao {
	public List<DeptVo> listDept(){
		return DeptManager.listDept(); 
	}
	
	
	public int insertDept(DeptVo d) {
		return DeptManager.insertDept(d);
	}
}
