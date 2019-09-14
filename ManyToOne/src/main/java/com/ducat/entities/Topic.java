package com.ducat.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Owner entity class.
@Entity
@Table(name="TopicMaster")
public class Topic {
	// State
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int weightage;
	//Relation
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="courseId")
	private Course course;
	
	public Topic(String name, int weightage) {
		super();
		this.name = name;
		this.weightage = weightage;
	}

	public Topic(String name, int weightage, Course course) {
		super();
		this.name = name;
		this.weightage = weightage;
		this.course = course;
	}

	public Topic() {
		super();
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getWeightage() {
		return weightage;
	}

	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	

	
	
	
}
