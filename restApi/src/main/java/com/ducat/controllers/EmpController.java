package com.ducat.controllers;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.daos.EmpDao;
import com.ducat.entities.Emp;


@RestController
@RequestMapping(path="/employees")
public class EmpController {

	
	@Autowired
	EmpDao dao;
	
	// To return all employees in JSON format.
	@GetMapping(value="/", produces="application/json")
	public  Iterable<Emp> getAll() {
		return dao.findAll();
	}
	
	// To return an employee using its Id in JSON format.
	@GetMapping(value="/{id}", produces="application/json")
	public Emp getById(
		@PathVariable	int id) {
		Emp emp = null;
		Optional<Emp> optional = dao.findById(id);
		if(optional.isPresent())
			emp = optional.get();
		
		return emp;
	}
	
	// To save an employee received in JSON format.
	@PostMapping(value="/", produces="text/plain",
			consumes="application/json")
	public String save(@RequestBody Emp emp) {
		
		dao.save(emp);
		return "Successfully saved.";
	}
	// To update an employee received in JSON format.
	@PutMapping(value="/", produces="text/plain",
			consumes="application/json")
	public String update(@RequestBody Emp emp) {
		dao.save(emp);
		return "Successfully updated.";
	}
	// To remove an employee using its id.
	@DeleteMapping(value="/{id}", produces="text/plain")
	public String remove(
			@PathVariable int id) {
		dao.deleteById(id);
		return "Successfully removed.";
	}
}
