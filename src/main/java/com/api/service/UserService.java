package com.api.service;

import com.api.dto.UserRequest;
import com.api.entity.User;
import com.api.exception.UserNotFoundException;
import com.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserRequest saveUser(UserRequest userRequest) {
    	User user = new User(userRequest.getFirstname(), userRequest.getLastname(), userRequest.getEmail(), userRequest.getGender(),
        		userRequest.getDob(), userRequest.getEducation(), userRequest.getCompany(), userRequest.getExperience(), userRequest.getPackag());

        return new UserRequest(repository.save(user), "Employee added successfully");
    }


    public List<User> getALlUsers() {
        return repository.findAll();
    }


    public Optional<User> getUser(Long id) throws UserNotFoundException {
        Optional<User> user= repository.findById(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("user not found with id : "+id);
        }
    }
    
    public UserRequest updateUser(UserRequest userRequest, Long id) {
    	User user = new User(userRequest.getFirstname(), userRequest.getLastname(), userRequest.getEmail(), userRequest.getGender(),
        		userRequest.getDob(), userRequest.getEducation(), userRequest.getCompany(), userRequest.getExperience(), userRequest.getPackag());
		
            user.setId(id);
            if(repository.findById(id).get() != null) {
            	return new UserRequest(repository.save(user), "Employee updated successfully");
            }else {
            	return new UserRequest(repository.save(user), "Employee not found with id: " + id);
            }
	}
	
	public UserRequest deleteUser(Long id) {
		if(repository.findById(id).get() != null) {
			Optional<User> userOptional = repository.findById(id);
			User user = userOptional.get(); 
        	repository.deleteById(id);
        	return new UserRequest(user, "Employee deleted successfully");
        }else {
        	return new UserRequest(new User(), "Employee can not be deleted");
        }
	}
}
