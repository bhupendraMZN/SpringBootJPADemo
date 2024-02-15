package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
	
	@Query("select case when count(e) > 0 then true else false end from User e where e.email = :email")
	Boolean existsByEmail(@Param ("email") String email);
	
	//public User findByEmail(String email);
	
}
