package com.ducat.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducat.entities.Emp;
import com.ducat.entities.Previlige;
import com.ducat.repos.PreviligeDao;

@Service
public class PreviligeService {

	@Autowired
	private PreviligeDao dao;
	
	
	
	public void load() {
		System.out.println("Loading Previliges...");
		Iterable<Previlige> itr = dao.findAll();
		itr.forEach(PreviligeService::display);
	}
	
	private static void display(Previlige p) {
		System.out.println("Previliges Details: "+p.getName()+"\t"+p.getCost());
		Set<Emp> employees = p.getEmployees();
		employees.forEach(PreviligeService::displayEmp);
	}
	public static void displayEmp(Emp e) {
		System.out.println(e.getName()+"\t"+e.getJob()+"\t"+e.getSalary());
		}
}
