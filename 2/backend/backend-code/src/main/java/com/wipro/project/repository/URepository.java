package com.wipro.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wipro.project.model.User;

public interface URepository extends CrudRepository<User, String> {
	
public User findByEmail(String email);
	
	//Custom queries using jpql in crud repo
    @Query("SELECT new com.wipro.project.model.User(d.id,d.email,d.fname,d.lname,"
            + "d.password,d.dob,d.phoneNo,d.street,d.city,d.pincode) "
            + "FROM User d")
    List<User> fetchUser();

}
