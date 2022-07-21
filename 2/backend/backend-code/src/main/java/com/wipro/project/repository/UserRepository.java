package com.wipro.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.project.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
