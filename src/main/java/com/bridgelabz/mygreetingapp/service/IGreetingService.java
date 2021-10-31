package com.bridgelabz.mygreetingapp.service;

import com.bridgelabz.mygreetingapp.model.Greeting;
import com.bridgelabz.mygreetingapp.model.User;

public interface IGreetingService {
	Greeting addGreeting(User user);
	Greeting getGreetingById(long id);

}
