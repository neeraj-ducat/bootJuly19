package com.ducat.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducat.entities.Course;
import com.ducat.entities.Topic;
import com.ducat.repos.CourseDao;
import com.ducat.repos.TopicDao;

@Service
public class TopicService {

	@Autowired
	private CourseDao cdao;
	@Autowired
	private TopicDao tdao;
	
	public void save() {
		System.out.println("Saving Topics...");
		Course c1 = new Course("Spring", 5000);
		Course c2 = new Course("Hibernate", 4000); 
		
		Set<Topic> s1 = new HashSet();
		s1.add(new Topic("IOC", 30, c1));
		s1.add(new Topic("AOP", 20, c1));
		s1.add(new Topic("MVC", 50, c1));
		
		
		Set<Topic> s2 = new HashSet();
		s2.add(new Topic("Mapping", 70, c2));
		s2.add(new Topic("HQL", 30, c2));
		
		tdao.saveAll(s1);
		tdao.saveAll(s2);
		System.out.println("successfully saved.");
	}
	
	public void load() {
		System.out.println("Loading Topics...");
		Iterable<Topic> itr = tdao.findAll();
		itr.forEach(TopicService::display);
	}
	
	private static void display(Topic t) {
		System.out.println(t.getName()+"\t"+t.getWeightage()
		+"\t"+t.getCourse().getName());
		  
	   
	}
	
	
}
