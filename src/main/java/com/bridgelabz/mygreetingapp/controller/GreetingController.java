package com.bridgelabz.mygreetingapp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.mygreetingapp.model.Greeting;
import com.bridgelabz.mygreetingapp.model.User;
import com.bridgelabz.mygreetingapp.service.IGreetingService;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private IGreetingService greetingService;
	
	 @GetMapping("")
	  public Greeting greeting(@RequestParam(value = "name",defaultValue = "World")String name){
	        User user = new User();
	        user.setFirstName(name);
	        return greetingService.addGreeting(user);
	 }
	 
	 @RequestMapping(value = { "/query" })
	 public Greeting sayHi(@RequestParam(value = "fName", defaultValue = "Harry") String fname,
	 		@RequestParam(value = "lName", defaultValue = "Potter") String lname) {
	 	return new Greeting(counter.incrementAndGet(),String.format(template, fname+" "+lname));
	 }

	 @GetMapping("/param/{message}")
	 public Greeting parameterName(@PathVariable String message) {
	 	return new Greeting(counter.incrementAndGet(),String.format(template, message));
	 	}

	 @PostMapping("/post")
	 public Greeting setUser(@RequestBody Greeting greeting) {
	 	return new Greeting(counter.incrementAndGet(),String.format(template, greeting.getMessage()));
	 }
	 @PutMapping("/put/{firstName}")
	 public Greeting sayHelloPutMethod(@PathVariable String firstName,@RequestParam(value="lastName",defaultValue="Potter") String lastName) {
	 	return new Greeting(counter.incrementAndGet(),String.format(template, firstName+" "+lastName));
	 }
	

}
