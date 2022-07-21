package com.wipro.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.project.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {
	

}
