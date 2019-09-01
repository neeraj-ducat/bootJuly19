package com.ducat.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="3")
public class Student extends Person {

	private String course;
	private int fee;
	
	
	public Student(String name, String course, int fee) {
		super(name);
		this.course = course;
		this.fee = fee;
	}
	public Student() {
		super();
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	
}
