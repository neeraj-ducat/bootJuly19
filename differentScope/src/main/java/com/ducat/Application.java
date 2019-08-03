package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	// Application is started and reference of
	//	ApplicationContext i.e. IOC Container is received.
	ApplicationContext ctx =	SpringApplication.run(
				Application.class, args);
	System.out.println("Requesting conductor from the container...");
	// Conductor con = (Conductor)ctx.getBean("dishonestConductor");
	// Conductor con = (Conductor)ctx.getBean("honestConductor");
	Conductor con = (Conductor)ctx.getBean("conductor");
	System.out.println("Conductor class is "+con.getClass().getName());
	System.out.println("Requesting 2 tickets from the conductor...");
	Ticket t1 = con.getTicket();
	Ticket t2 = con.getTicket();
	System.out.println("Details of first Ticket: "+t1);
	System.out.println("Details of second Ticket: "+t2);
	}
}
