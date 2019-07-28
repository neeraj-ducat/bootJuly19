package com.ducat.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope("prototype")
public class B {

	public B()
	{
		System.out.println("B is instantiated.");
	}
}
