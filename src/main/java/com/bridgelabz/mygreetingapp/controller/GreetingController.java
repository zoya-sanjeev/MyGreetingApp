package com.bridgelabz.mygreetingapp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.mygreetingapp.model.Greeting;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
	
	@Autowired
	private IGreetingService greetingService;
	
	 @GetMapping("")
	  public Greeting greeting(@RequestParam(value = "name",defaultValue = "World")String name){
	        User user - new User();
	        user.setFirstName(name)l
	        return greetingService.addGreeting(user);
	 }
	

}
