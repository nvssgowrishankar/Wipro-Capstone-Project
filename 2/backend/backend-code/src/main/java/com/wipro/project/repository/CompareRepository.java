package com.wipro.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.project.model.Compare;

public interface CompareRepository extends MongoRepository<Compare, String> {

}
