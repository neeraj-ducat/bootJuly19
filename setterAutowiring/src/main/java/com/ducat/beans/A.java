package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class A {

	
	private B b;
	
	public A() {
		System.out.println("A is created.");
	}
	//setter autowiring
	@Autowired
	public void setB(B b) {
		this.b = b;
		System.out.println("setB() of A is invoked.");
	}

	public boolean hasB() {
		if(b == null)
			return false;
		else
			return true;
	}
}
