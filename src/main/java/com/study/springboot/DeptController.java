package com.study.springboot;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor  //의존성 주입
@RequestMapping("/dept/*")
public class DeptController {
	private final DeptDao deptDao;
	
	@GetMapping("/list") 
	public void list(Model model) {
		List<Dept> list = deptDao.deptList();
		model.addAttribute("list",list);
		log.info("----------------dept 리스트");		
	}
	
	@PostMapping("/insert")
	public String insertAct(Dept dept) {
		int res = deptDao.deptInsert(dept);
		return "redirect:list";
	}
	
	@GetMapping("/insert")
	public void insert() {
		
	}
	

	@GetMapping("/update")
	public void update(int deptno, Model model) {
		Dept dept = deptDao.deptViewOne(deptno);
		model.addAttribute("dept", dept);
	}
	
	@PostMapping("/update")
	public String upload(Dept dept) {
		deptDao.deptUpdate(dept);
		return "redirect:list";
	}
	
	
	@GetMapping("/delete")
	public String delete(int deptno) {
		deptDao.deptDelete(deptno);
		return "redirect:list";
	}
}
