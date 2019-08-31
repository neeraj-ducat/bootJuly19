package com.ducat.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducat.entities.Employee;

@Repository
public interface EmployeeDao extends 
		CrudRepository<Employee, Integer>{

}
