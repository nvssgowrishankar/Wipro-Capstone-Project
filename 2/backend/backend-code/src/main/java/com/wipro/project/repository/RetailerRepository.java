package com.wipro.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.project.model.Retailer;

public interface RetailerRepository extends MongoRepository<Retailer, String> {

}
