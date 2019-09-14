package com.ducat.entities;

import java.util.Set;

import javax.persistence.*;

//Owner entity class.

@Entity
@Table(name="Emp")
public class Emp {
  
	//State
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name, job;
	private int salary;
	//Relation
	@ManyToMany(cascade= {CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinTable(name="Emp_Previlige",
	joinColumns= {@JoinColumn(name="empId")},
	inverseJoinColumns= {@JoinColumn(name="previligeId")})
	private Set<Previlige> previliges;
	
	
	public Emp() {
		super();
	}


	public Emp(String name, String job, int salary, Set<Previlige> previliges) {
		super();
		this.name = name;
		this.job = job;
		this.salary = salary;
		this.previliges = previliges;
	}


	public Emp(String name, String job, int salary) {
		super();
		this.name = name;
		this.job = job;
		this.salary = salary;
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


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public Set<Previlige> getPreviliges() {
		return previliges;
	}


	public void setPreviliges(Set<Previlige> previliges) {
		this.previliges = previliges;
	}
	
	
}
