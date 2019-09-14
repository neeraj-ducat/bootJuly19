package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.services.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		EmpService es = (EmpService)ctx.getBean("empService");
		PreviligeService ps = (PreviligeService)ctx.getBean("previligeService");
		es.save();
		System.out.println("Loading employees...");
		es.load();
		System.out.println("Loading previliges...");
		ps.load();
		//es.loadInAscOrderOfName();
	}

}
