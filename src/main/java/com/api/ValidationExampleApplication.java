package com.api;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.api.entity.User;
import com.api.repository.UserRepository;


@SpringBootApplication
public class ValidationExampleApplication implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ValidationExampleApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
				
		userRepository.save(new User("Bhupe", "Sharma", "ab@gmail.com", "male", new Date(12/03/1976), "Masters", "ABC", "12", "15"));
		userRepository.save(new User("Rani", "Singh", "bh@gmail.com", "female", new Date(12/04/2008), "Masters", "ABC", "10", "5"));
		
	}
	
	@Bean
	WebMvcConfigurer corsConfigurer()
	{
	   String[] allowDomains = new String[3];
	   allowDomains[0] = "http://localhost:4200";
	   allowDomains[1] = "http://localhost:8080";
	   allowDomains[2] = "http://localhost:8081";

	   System.out.println("CORS configuration....");
	   return new WebMvcConfigurer() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	         registry.addMapping("/**").allowedOrigins(allowDomains).allowedMethods(HttpMethod.DELETE.name(), HttpMethod.PUT.name(), HttpMethod.GET.name(), HttpMethod.POST.name());
	      }
	   };
	}

}
