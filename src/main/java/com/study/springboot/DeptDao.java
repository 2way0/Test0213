package com.study.springboot;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptDao {   // 인터페이스임 - MyBatis가 구현해 줌
	public List<Dept> deptList();
	public int deptInsert(Dept dept);
	public Dept deptViewOne(int deptno);
	public int deptUpdate(Dept dept);
	public int deptDelete(int deptno);
	
}
