package com.validation;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.repository.UserRepository;

public class Validator {
	
	@Autowired
	UserRepository userRepository;
	
	
	
	
	//validate age
    public Boolean ageVerify (Date dob) {
    	Boolean x = false;
		 try {
	            Calendar birthCalendar = Calendar.getInstance();
	            birthCalendar.setTime(dob);
	            
	            Calendar nowCalendar = Calendar.getInstance();
	            nowCalendar.setTime(new Date());
	            
	            int age = nowCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
	            
	            if(age < 18 || age > 60) {
	            	System.out.println("you are under age");
	            	x = true;
	            }
		 } 
		 catch (Exception e) {}
    	return x;
    } 

}
