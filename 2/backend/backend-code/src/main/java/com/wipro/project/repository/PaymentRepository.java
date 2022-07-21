package com.wipro.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.project.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {

}
