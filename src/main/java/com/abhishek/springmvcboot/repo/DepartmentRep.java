package com.abhishek.springmvcboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhishek.springmvcboot.entity.Department;
import com.abhishek.springmvcboot.entity.Student;

@Repository
public interface DepartmentRep extends JpaRepository<Department, Long>{

}
