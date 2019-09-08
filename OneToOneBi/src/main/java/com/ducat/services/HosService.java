package com.ducat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducat.entities.Country;
import com.ducat.entities.HeadOfState;
import com.ducat.repos.HosDao;

@Service
public class HosService {

	@Autowired
	private HosDao dao;
	
	
	
	public void load() {
		System.out.println("Loading Head of states...");
		Iterable<HeadOfState> itr = dao.findAll();
		itr.forEach(HosService::display);
	}
	
	private static void display(HeadOfState hos) {
		System.out.println("Head of State: "+hos.getTitle()+"\t"+hos.getName());
		Country c = hos.getCountry();
		System.out.println("Country Name: "+c.getName());
	}
}
