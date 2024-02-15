package com.api.controller;

import com.api.dto.UserRequest;
import com.api.entity.User;
import com.api.exception.UserNotFoundException;
import com.api.repository.UserRepository;
import com.api.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;
    
    @Autowired
    UserRepository userRepository;

  @PostMapping("/signup")
  public ResponseEntity<UserRequest> saveUser(@RequestBody @Valid UserRequest userRequest){
      if(userRepository.existsByEmail(userRequest.getEmail())) {
    	  userRequest.setMessage("email alreday exist !");
    	  return new ResponseEntity<>(userRequest, HttpStatus.BAD_REQUEST);
      }      
      else if (ageVerify(userRequest.getDob()) || userRequest.getDob()==null) {
    	  userRequest.setMessage("invalid age, you must be over 18 or below 60");
    	  return new ResponseEntity<>(userRequest, HttpStatus.BAD_REQUEST);
      }
      else {
    	  return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
      }      
  }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(service.getALlUsers());
    }

    @GetMapping("userById")
    public ResponseEntity<Optional<User>> getUser(@RequestParam Long id) throws UserNotFoundException {
    	System.out.println(service.getUser(id));
        return ResponseEntity.ok(service.getUser(id));
    }
    
    @PutMapping("/updateUser")
   	public ResponseEntity<UserRequest> updateUser(@RequestBody @Valid UserRequest userRequest, @RequestParam Long id) {		
   			//call validate email and age both
   			
//   			if(userRepository.existsByEmail(userRequest.getEmail())) {
//   	    	  userRequest.setMessage("email alreday exist !");
//   	    	  return new ResponseEntity<>(userRequest, HttpStatus.BAD_REQUEST);
//   	      }
    		
   	       if (ageVerify(userRequest.getDob()) || userRequest.getDob()==null) {
   	    	  userRequest.setMessage("invalid age, you must be over 18 or below 60");
   	    	  return new ResponseEntity<>(userRequest, HttpStatus.BAD_REQUEST);
   	      }
   	      else {
   	    	  return new ResponseEntity<>(service.updateUser(userRequest, id), HttpStatus.CREATED);
   	      }
   	}
	
    @DeleteMapping("/deleteUser")
	public ResponseEntity<UserRequest> deleteUser(@RequestParam Long id) {
    	return new ResponseEntity<>(service.deleteUser(id), HttpStatus.OK);
	}
    
        
    //validate age
    private Boolean ageVerify (Date dob) {
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
    
//    private Boolean updateEmailExist(UserRequest userRequest) {
//    	Boolean x=true;
//    	System.out.println("updateEmailExist 111111");
//    	User user = userRepository.findByEmail(userRequest.getEmail());
//    	System.out.println("updateEmailExist 22222222");
//    	if(user!=null) {
//    		System.out.println("updateEmailExist 3333333333");
//    		if(user.getFirstname()==userRequest.getFirstname() && user.getDob()==userRequest.getDob()) {
//    			System.out.println("updateEmailExist 444444444");
//    			x=false;
//    		}    		
//    	}
//    	
//    	return x;    	
//    }
        
}
