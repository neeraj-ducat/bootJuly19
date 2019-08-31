package com.ducat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducat.daos.EmployeeDao;
import com.ducat.entities.Employee;

@Service
public class EmpFinder {
	@Autowired
	EmployeeDao dao;
	
	public void getAll() {
	System.out.println("Following employees are loaded:");
	Iterable<Employee> list = dao.findAll();
	list.forEach(emp -> {
		System.out.println(
				emp.getId()+"\t"+emp.getName()+"\t"+
				emp.getJob()+"\t"+emp.getSalary());
	});
	}
	
	
}
