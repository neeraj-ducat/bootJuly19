package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.A;

@SpringBootApplication
public class FirstBootApplication {

	public static void main(String[] args) {
	// Application is started and reference of
	//	ApplicationContext i.e. IOC Container is received.
	ApplicationContext ctx =	SpringApplication.run(
				FirstBootApplication.class, args);
	System.out.println("Application is started, requesting A bean from the container...");
	A a1 = (A)ctx.getBean("a");
	System.out.println("A bean is received.");

	}

}
