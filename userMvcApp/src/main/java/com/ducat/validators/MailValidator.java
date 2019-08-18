package com.ducat.validators;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ducat.daos.UserDao;
import com.ducat.entities.User;

@Component
public class MailValidator implements Validator
{
	@Autowired
	private UserDao dao;

	@Override
	public boolean supports(Class<?> cl) {
		
		return cl.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user=(User)target;
		Optional<User> optional=dao.findByMailId(user.getMailId());
		if(optional.isPresent())
		{
			//mailId already exists, fail the validation
			errors.rejectValue("mailId", "mailId", "Already registered.");
		}
		
	}

}
