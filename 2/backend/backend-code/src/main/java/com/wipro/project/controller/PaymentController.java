package com.wipro.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.project.model.Payment;
import com.wipro.project.repository.PaymentRepository;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins="http://localhost:4200")
public class PaymentController {
	
	@Autowired
	private PaymentRepository prepo;
	
	@GetMapping("/payments")
	public List<Payment> getAllProducts() {
		return prepo.findAll(); 
	}
	
	@PostMapping("/payments")
    public Payment saveProduct(@Validated @RequestBody Payment payment) {
     return prepo.save(payment);
                    
	}

}
