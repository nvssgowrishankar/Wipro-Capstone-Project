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
import com.wipro.project.model.Compare;
import com.wipro.project.repository.CompareRepository;

@RestController
@RequestMapping("/compare")
@CrossOrigin(origins="http://localhost:4200")
public class CompareController {
	
	@Autowired
	private CompareRepository crepo;
	
	@GetMapping("/compareproducts")
	public List<Compare> getAllProducts() {
		return crepo.findAll(); 
	}
	
	@GetMapping("/compareproducts/{id}")
	public ResponseEntity<Compare> getProductById(@PathVariable(value = "id") String pId)
			throws ResourceNotFoundException {
		Compare ct = crepo.findById(pId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));
		return ResponseEntity.ok().body(ct);
	}
	
	@PostMapping("/compareproducts")
    public Compare saveProduct(@Validated @RequestBody Compare compare) {
     return crepo.save(compare);
                    
	}
	
	
	@DeleteMapping("/compareproducts/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") String pId)
            throws ResourceNotFoundException{
     Compare ct = crepo.findById(pId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));
        crepo.delete(ct);
       
        Map <String, Boolean> response = new HashMap <String,Boolean>();
        response.put("Deleted", Boolean.TRUE);
        return response;
        
    }
	
	@DeleteMapping("/deleteall")
	public String deleteProducts() {
		
		crepo.deleteAll();
		
		return "Deleted Succesfully";
	}

}
