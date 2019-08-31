package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.services.EmpFinder;
import com.ducat.services.EmpSaver;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		
	ApplicationContext ctx =	SpringApplication.run(JpaApplication.class, args);
	System.out.println("Requesting EmpSaver bean...");
	/*EmpSaver saver = (EmpSaver)ctx.getBean("empSaver");
	System.out.println("Saving 2 objects...");
	for(int i=0;i<2;i++) {
		saver.save();
		}
	
	saver.closeStream();
	*/
	System.out.println("Following employees are loaded");
	EmpFinder finder = (EmpFinder)ctx.getBean("empFinder");
	finder.getAll();
	}
}
