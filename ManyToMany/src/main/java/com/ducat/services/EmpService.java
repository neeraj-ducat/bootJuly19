package com.ducat.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducat.entities.*;
import com.ducat.repos.EmpDao;

@Service
public class EmpService {

	@Autowired
	private EmpDao dao;
	
	public void save() {
		System.out.println("Saving Employees...");
		Previlige p1 = new Previlige("Car", 120000);
		Previlige p2 = new Previlige("Flat", 300000);
		Previlige p3 = new Previlige("Club Membership", 250000);
		Set<Previlige> s1 = new HashSet();
		s1.add(p1); s1.add(p2); s1.add(p3);
		Set<Previlige> s2 = new HashSet();
		s2.add(p1); s2.add(p2); 
		Set<Previlige> s3 = new HashSet();
		s3.add(p1); 
		
		Emp e1 = new Emp("Ravi","CEO",250000, s1);
		Emp e2 = new Emp("Ankit","CTO",225000,s2);
		Emp e3 = new Emp("Vipul","COO",200000, s3);
		Set<Emp> employees = new HashSet();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		dao.saveAll(employees);
		System.out.println("successfully saved.");
	}
	
	public void load() {
		System.out.println("Loading employees objects...");
		Iterable<Emp> itr = dao.findAll();
		itr.forEach(EmpService::display);
	}
	
	private static void display(Emp e) {
		System.out.println("Emp Details: "+e.getName()+"\t"+e.getJob()+"\t"+e.getSalary());
		Set<Previlige> previliges = e.getPreviliges();
		System.out.println("Previliges availed by the Emp: ");
		previliges.forEach(EmpService::displayPreviliges);
	}
	public static void displayPreviliges(Previlige p) {
		System.out.println(p.getName()+"\t"+p.getCost());
	}
	/*public void loadInAscOrderOfName() {
		System.out.println("Loading employees in asc order of name...");
		Iterable<Emp> itr = dao.findAllOrderByNameAsc();
		itr.forEach(e -> System.out.println(e.getName()+"\t"+e.getJob()+"\t"+e.getSalary()));
	}*/
	
}
