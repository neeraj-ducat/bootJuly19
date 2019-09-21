package com.ducat.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.entities.Course;
import com.ducat.repos.CourseDao;

@RestController
public class CourseController {

	@Autowired
	private CourseDao dao;
	// To fetch all courses.
	@GetMapping(value="/courses", produces="application/json")
	public Iterable<Course> getAllCourses() {
		
		return dao.findAll();
	}
	
	// To fetch a course using its id.
	@GetMapping(value="/courses/{id}", produces="application/json")
	public Course byId( 
		@PathVariable	int id) {
		Course course = null;
		Optional<Course> opt = dao.findById(id);	
		if (opt.isPresent())
			course = opt.get();
		
		return course;
	}
	
	// To save a course.
	@PostMapping(value="/courses", produces="text/plain",
			consumes="application/json")
	public String save(
		@RequestBody Course course) {
		dao.save(course);
		return "successfully saved.";
	}
}
