package com.bridgelabz.mygreetingapp.repository;
import com.bridgelabz.greetingsapp.model.Greeting;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}
