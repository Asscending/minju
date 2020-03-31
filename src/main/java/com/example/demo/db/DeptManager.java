package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DeptVo;

public class DeptManager {
private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader =   
					Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}
	
	public static List<DeptVo> listDept(){
		SqlSession session = factory.openSession();
		List<DeptVo> list = session.selectList("dept.listDept");
		session.close();
		return list;
	}
	public static int insertDept(DeptVo d) {
		SqlSession session = factory.openSession();
		int re = session.insert("dept.insertDept", d);
		session.commit();
		session.close();
		return re;
	}
}
