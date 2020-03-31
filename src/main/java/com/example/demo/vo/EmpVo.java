package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class EmpVo {
	private int eno;
	private String ename;
	private String job;
	private int sal;
	private int comm;
	private int mgr;
	private String hiredate;
	private int dno;
	private String email;
	private String jumin;

}
