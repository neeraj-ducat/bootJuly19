package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.services.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		CourseService cs = (CourseService)ctx.getBean("courseService");
		TopicService ts = (TopicService)ctx.getBean("topicService");
		//ts.save();
		
		cs.load();
		ts.load();
	}

}
