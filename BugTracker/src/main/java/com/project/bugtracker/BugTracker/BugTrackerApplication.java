package com.project.bugtracker.BugTracker;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class BugTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerApplication.class, args);
		System.out.println("App has started!!");
	}

	@Bean
	@Scope("prototype")
	public ModelMapper modelMapper (){
		return new ModelMapper();
	}
}
