package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.EmpVo;

public class EmpManager {
	
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
	
	public static List<EmpVo> listEmp(){
		SqlSession session = factory.openSession();
		List<EmpVo> list = session.selectList("emp.listEmp");
		session.close();
		return list;
	}
	
	public static EmpVo detailEmp(EmpVo v) {
		SqlSession session = factory.openSession();
		EmpVo ev = session.selectOne("emp.detailEmp",v);
		session.close();
		return ev;
	}
	
	public static int nextEno() {
		SqlSession session = factory.openSession();
		int no = session.selectOne("emp.nextEno");
		session.close();
		return no;
	}
	
	public static int insertEmp(EmpVo v) {
		SqlSession session = factory.openSession();
		int re = session.insert("emp.insertEmp", v);
		session.commit();
		session.close();
		return re;
	}
	public static int updateEmp(EmpVo v) {
		SqlSession session = factory.openSession();
		int re = session.update("emp.updateEmp", v);
		session.commit();
		session.close();
		return re;
	}
	public static int deleteEmp(EmpVo v) {
		SqlSession session = factory.openSession();
		int re = session.delete("emp.deleteEmp", v);
		session.commit();
		session.close();
		return re;
	}

}
