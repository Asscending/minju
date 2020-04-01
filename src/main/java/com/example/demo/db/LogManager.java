package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.LogVo;

public class LogManager {
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static List<LogVo> listLog(){
		SqlSession session = factory.openSession();
		List<LogVo> list = session.selectList("log.listLog");
		session.close();
		return list;
	}
	
	public static int insert(LogVo vo) {
		SqlSession session = factory.openSession();
		int re = session.insert("log.insertLog",vo);
		session.close();
		return re;
	}
}
