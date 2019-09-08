package com.ducat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducat.daos.EmpDao;
import com.ducat.daos.PersonDao;
import com.ducat.daos.StudentDao;
import com.ducat.entities.Emp;
import com.ducat.entities.Person;
import com.ducat.entities.Student;

@Service
public class PersonService {

	@Autowired
	EmpDao empDao;
	@Autowired
	PersonDao personDao;
	@Autowired
	StudentDao studentDao;
	
	public void save() {
		System.out.println("Saving objects of person family...");
		Person p = new Person("Amit");
		Emp e = new Emp("Ravi", "Trainee",23000);
		Student s = new Student("Kapil","Java",12000);
		personDao.save(p);
		empDao.save(e);
		studentDao.save(s);
		System.out.println("Successfully saved.");
	}
	public void load() {
		System.out.println("Loading objects of person family...");
		Iterable<Person> persons = personDao.findAll();
		persons.forEach(PersonService::display);
	}
	
	private static void display(Person p) {
		if(p instanceof Student) {
			Student s = (Student) p;
			System.out.println(s.getName()+"\t"+s.getCourse()+"\t"+s.getFee());
			} else if(p instanceof Emp){
			Emp e = (Emp) p;
			System.out.println(e.getName()+"\t"+e.getJob()+"\t"+e.getSalary());
		} else
		{
			System.out.println(p.getName());
			
		}
	}
}
