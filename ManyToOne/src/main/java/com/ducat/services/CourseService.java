package com.ducat.services;

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
