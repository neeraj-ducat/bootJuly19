package com.ducat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.services.PersonService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext ctx =
				SpringApplication.run(Application.class, args);
		
	   System.out.println("Obtaining person Service...");
	   PersonService ps =
			   (PersonService)ctx.getBean("personService");
	   ps.save();
	   ps.load();
	}

}
