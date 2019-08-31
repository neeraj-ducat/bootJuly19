package com.ducat.services;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducat.daos.EmployeeDao;
import com.ducat.entities.Employee;

@Service
public class EmpSaver {
	@Autowired
	EmployeeDao dao;
	private static Scanner in = new Scanner(System.in);
	
	public void save() {
		Employee e = new Employee();
		System.out.print("Enter Name: ");
		e.setName(in.nextLine());
		System.out.print("Enter Job: ");
		e.setJob(in.nextLine());
		System.out.print("Enter Salary: ");
		e.setSalary(in.nextInt());
		in.nextLine(); // unread \n is removed from the buffer
		dao.save(e);
		System.out.println("successfully saved.");
	}
	public void closeStream() {
		in.close();
	}
	
}
