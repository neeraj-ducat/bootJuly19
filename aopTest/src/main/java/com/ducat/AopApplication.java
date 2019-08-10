package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.*;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
	// Application is started and reference of
	//	ApplicationContext i.e. IOC Container is received.
	ApplicationContext ctx =	SpringApplication.run(
				AopApplication.class, args);
	System.out.println("Requesting an ABC bean...");
	ABC bean = (ABC) ctx.getBean("target");
	System.out.println("Bean received, invoking its a() method...");
	bean.a();
	System.out.println("Invoking b() method...");
	String result = bean.b();
    System.out.println(result+" is returned by b() in main.");
    try
    {
    	System.out.println("Invoking c() method...");
    	bean.c(-5);
    }catch(Exception e)
    {
    	System.out.println("Following exception is caught in main: "+e);
    }
	}

}
