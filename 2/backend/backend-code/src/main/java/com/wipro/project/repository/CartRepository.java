package com.wipro.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.project.model.Cart;

public interface CartRepository extends MongoRepository<Cart, String> {

}
