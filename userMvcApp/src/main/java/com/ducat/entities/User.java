package com.ducat.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name="UsersMaster")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Pattern(regexp="[a-z,A-Z]{2}[a-z,A-Z]*",message="Name can have only alphabets.")
	private String name;
	@NotEmpty(message="Mailid is required.")
	@Email(message="MailId should be in proper format.")
	private String mailId;
	@Length(min=4, message="Password must have at least 4 chars.")
	private String password;
	private String roles;
	
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
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
	
}
