package com.ducat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducat.entities.Country;
import com.ducat.entities.HeadOfState;
import com.ducat.repos.CountryDao;

@Service
public class CountryService {

	@Autowired
	private CountryDao dao;
	
	public void save() {
		System.out.println("Saving two country objects...");
		Country c1 = new Country("India", new HeadOfState("President","R.N.Kovind"));
		Country c2 = new Country("UK", new HeadOfState("Queen","Elizabeth II"));
		dao.save(c1);
		dao.save(c2);
		System.out.println("successfully saved.");
	}
	
	public void load() {
		System.out.println("Loading country objects...");
		Iterable<Country> itr = dao.findAll();
		itr.forEach(CountryService::display);
	}
	
	private static void display(Country c) {
		System.out.println("Country Name: "+c.getName());
		HeadOfState hos = c.getHos();
		System.out.println("Head of State: "+hos.getTitle()+"\t"+hos.getName());
	}
}
