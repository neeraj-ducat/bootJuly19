package com.ducat.entities;

import java.util.Set;

import javax.persistence.*;

//Owned entity class.

@Entity
@Table(name="CourseMaster")
public class Course {
  
	//State
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int fee;
	//Relation
	@OneToMany(mappedBy="course" ,fetch = FetchType.EAGER)
	private Set<Topic> topics;
	
	
	public Course() {
		super();
	}

	public Course(String name, int fee, Set<Topic> topics) {
		super();
		this.name = name;
		this.fee = fee;
		this.topics = topics;
	}

	public Course(String name, int fee) {
		super();
		this.name = name;
		this.fee = fee;
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

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}


	
}
