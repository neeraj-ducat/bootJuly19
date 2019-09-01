package com.ducat.entities;

import javax.persistence.*;

@Entity
@Table(name="Persons")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="personType", discriminatorType=DiscriminatorType.INTEGER)
@DiscriminatorValue(value="1")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	
	public Person(String name) {
		super();
		this.name = name;
	}
	public Person() {
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
	
}
