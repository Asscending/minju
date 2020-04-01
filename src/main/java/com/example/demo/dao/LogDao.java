package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.LogManager;
import com.example.demo.vo.LogVo;

@Repository
public class LogDao {
	
	public List<LogVo> listAll(){
		return LogManager.listLog();
	}
	
	public int insert(LogVo vo) {
		return LogManager.insert(vo);
	}
}
