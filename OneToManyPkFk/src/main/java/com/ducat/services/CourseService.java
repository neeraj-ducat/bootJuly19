package com.ducat.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducat.entities.Course;
import com.ducat.entities.Topic;
import com.ducat.repos.CourseDao;

@Service
public class CourseService {

	@Autowired
	private CourseDao dao;
	
	public void save() {
		System.out.println("Saving Courses...");
		Set<Topic> s1 = new HashSet();
		s1.add(new Topic("IOC", 30));
		s1.add(new Topic("AOP", 20));
		s1.add(new Topic("MVC", 50));
		
		Course c1 = new Course("Spring", 5000, s1);
		Set<Topic> s2 = new HashSet();
		s2.add(new Topic("Persistent Operations", 20));
		s2.add(new Topic("Mappping", 80));
		Course c2 = new Course("Hibernate", 4000, s2); 
		
		
		Set<Course> courses = new HashSet();
		courses.add(c1);
		courses.add(c2);
		dao.saveAll(courses);
		System.out.println("successfully saved.");
	}
	
	public void load() {
		System.out.println("Loading Courses...");
		Iterable<Course> itr = dao.findAll();
		itr.forEach(CourseService::display);
	}
	
	private static void display(Course c) {
		System.out.println(c.getName()+"\t"+c.getFee());
		Set<Topic> topics = c.getTopics();
		System.out.println("Topics: ");
		topics.forEach(t -> System.out.println(t.getName()+"\t"+t.getWeightage()));
	  
	   
	}
	
	
}
