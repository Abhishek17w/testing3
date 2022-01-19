package com.abhishek.springmvcboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.springmvcboot.entity.Department;
import com.abhishek.springmvcboot.entity.Student;
import com.abhishek.springmvcboot.repo.DepartmentRep;
import com.abhishek.springmvcboot.repo.StudentRepo;

@RestController
public class testController {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private DepartmentRep departmentRepo;

	@PostMapping("/createStudent")
	public Student createStudent(@RequestParam String name, @RequestParam Long dId) {
		System.out.println("student creation started ");
		Department d = departmentRepo.findById(dId).get();
		System.out.println(d.getName());
		System.out.println(d.getId());
		
		Student st = new Student();
		st.setName(name);
		st.setDepartment(d);
		
		return studentRepo.save(st);
	}
	
	@PostMapping("/createDepartment")
	public List<Department> createDepartment(@RequestBody List<Department> dp) {
		//System.out.println("department creation started = " + dp.getName());
		
		List<Department> d = departmentRepo.saveAll(dp);
		System.out.println("department created");
		
		return d;
	}
}
