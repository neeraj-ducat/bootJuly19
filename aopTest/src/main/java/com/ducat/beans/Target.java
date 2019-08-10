package com.ducat.beans;

import org.springframework.stereotype.Component;

@Component
public class Target implements ABC {

	public void a() {
		System.out.println("a() of Target is invoked.");

	}

	public String b() {
		System.out.println("b() of Target is invoked, returning success");
		return "success";
	}

	public void c(int x) throws Exception {
		System.out.println("c() of Target is invoked.");
		if(x < 0) {
			System.out.println("Throwing exception...");
			throw(new Exception("Input should be > 0"));
		}
		else
		{
			System.out.println("Returning normally.");
		}

	}

}
