package com.ducat.daos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ducat.entities.User;

@Repository
public interface UserDao extends 
		CrudRepository<User, Integer>{

	// to load a user using its mailId
	public Optional<User> findByMailId(String mailId);
}
