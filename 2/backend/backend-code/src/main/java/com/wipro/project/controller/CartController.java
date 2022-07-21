package com.wipro.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.project.exception.ResourceNotFoundException;
import com.wipro.project.model.Cart;
import com.wipro.project.repository.CartRepository;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins="http://localhost:4200")
public class CartController {

	@Autowired
	private CartRepository crepo;
	
	@GetMapping("/cartproducts")
	public List<Cart> getAllProducts() {
		return crepo.findAll(); 
	}
	
	@GetMapping("/cartproducts/{id}")
	public ResponseEntity<Cart> getProductById(@PathVariable(value = "id") String pId)
			throws ResourceNotFoundException {
		Cart ct = crepo.findById(pId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));
		return ResponseEntity.ok().body(ct);
	}
	
	@PostMapping("/cartproducts")
    public Cart saveProduct(@Validated @RequestBody Cart cart) {
     return crepo.save(cart);
                    
	}
	
	
	@DeleteMapping("/cartproducts/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") String pId)
            throws ResourceNotFoundException{
     Cart ct = crepo.findById(pId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));
        crepo.delete(ct);
       
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("Deleted", Boolean.TRUE);
        return response;
        
    }
}
