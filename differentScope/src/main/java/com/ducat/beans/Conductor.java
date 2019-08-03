package com.ducat.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public abstract class Conductor {

	// container will dynamically create a sub class 
	// of Conductor and will implement getTicket()
	// method in it.
	@Lookup
	public abstract Ticket getTicket();
	
}
