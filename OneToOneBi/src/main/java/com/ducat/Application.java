package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.services.CountryService;
import com.ducat.services.HosService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		CountryService cs = (CountryService)ctx.getBean("countryService");
		HosService hs = (HosService)ctx.getBean("hosService");
		//cs.save();
		cs.load();
		hs.load();
	}

}
