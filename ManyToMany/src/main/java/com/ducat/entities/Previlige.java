package com.ducat.entities;

import java.util.Set;

import javax.persistence.*;

//Owned entity class.
@Entity
@Table(name="Previliges")
public class Previlige {
	// State
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int cost;
	//Relation 
	@ManyToMany(mappedBy="previliges",fetch=FetchType.EAGER)
		private Set<Emp> employees;
	
	
	
	public Previlige(String name, int cost) {
		super();
		this.name = name;
		this.cost = cost;
	}

	public Previlige() {
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Set<Emp> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Emp> employees) {
		this.employees = employees;
	}

	
	
	
}
