package com.api;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import com.api.entity.User;

public class demoExample {

	public static void main(String[] args) {
		
	        // validate inputs ...
		
		String dob1 = "03-23-1964";
		int min =18;
		int max =60;
		 try {
	        DateFormat formatter = new SimpleDateFormat("mm-dd-yyyy");
	        Date dob = formatter.parse(dob1);
	            Calendar birthCalendar = Calendar.getInstance();
	            birthCalendar.setTime(dob);
	            
	            Calendar nowCalendar = Calendar.getInstance();
	            nowCalendar.setTime(new Date());
	            
	            int age = nowCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
	            
	            if(age < 18 ) {
	            	System.out.println("you are under age");
	            }else if (age > 60) {
	            	System.out.println("you are over age");
	            }else {
	            	System.out.println(age);
	            }
		 } 
		 catch (Exception e) {}
		 
		 
		 
		//learn lambda expression
			
			ArrayList<Integer> str = new ArrayList<Integer>();
			str.add(1);
			str.add(2);
			
		    
		    str.forEach( (n) -> { System.out.println(n); } );
	}
	
	
	
    //validate email this is not right way but still testing I am not using this method 
//    private Boolean emailVerify (String email) {
//		Boolean x = false;
//		List <User> user = new ArrayList<>();
//		//service.getALlUsers().forEach(user::add);
//		
//		Iterator<User> itr = user.iterator();
//		
//		while(itr.hasNext()) {
//			User user1 = itr.next();
//			if(user1.getEmail().equalsIgnoreCase(email)) {
//				x=true;
//			}
//		}		
//		return x;		
//	}
    
    //following methods from UserSrervice for reference
//  public void updateUser(UserRequest userRequest, Long id) {
//	User user = new User(userRequest.getFirstname(), userRequest.getLastname(), userRequest.getEmail(), userRequest.getGender(),
//    		userRequest.getDob(), userRequest.getEducation(), userRequest.getCompany(), userRequest.getExperience(), userRequest.getPackag());
//	
//        user.setId(id);
//        if(repository.findById(id).get() != null) {
//        	repository.save(user);
//        	//return new UserRequest(repository.save(user), "Employee updated successfully");
//        }else {
//        	//return new UserRequest(repository.save(user), "Employee not found with id: " + id);
//        }
//}
    
//	public void deleteUser(Long id) {
//	if(repository.findById(id).get() != null) {
//    	repository.deleteById(id);
//    } 
//}

    
    //following methods from UserController for reference
    
//  @PutMapping("/updateUser")
//	public void updateUser(@RequestBody @Valid UserRequest userRequest, @RequestParam Long id) {		
//			//call validate email and age both
//			service.updateUser(userRequest, id);
//	}
    
    
//  @DeleteMapping("/deleteUser")
//	public void deleteUser(@RequestParam Long id) {
//			service.deleteUser(id);
//	}
    
    
//  @PostMapping("/signup")
//  public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
//      return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
//      
////  	if(userRepository.existsByEmail(userRequest.getEmail())) {
//////			employeeDetailsDTO = new EmployeeDetailsDTO(emp, "email alreday exist");
//////			return employeeDetailsDTO;
//////			throw new EmployeeNotFoundException(emp.getEmail());
////			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
////		}else {
////			return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
////		}
//  }
}
