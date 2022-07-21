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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.project.exception.ResourceNotFoundException;
import com.wipro.project.model.Product;
import com.wipro.project.repository.ProductRepository;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins="http://localhost:4200")
public class ProductController {
	
	@Autowired
	private ProductRepository prepo;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return prepo.findAll(); 
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") String pId)
			throws ResourceNotFoundException {
		Product product = prepo.findById(pId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));
		return ResponseEntity.ok().body(product);
	}
	
	@GetMapping("/{category}")
	public List<Product> getProductByCategory(@PathVariable(value="category") String category){
		
		return (List<Product>) prepo.findByCategoryContaining(category);
	}
	
	@GetMapping("/get/{name}")
	public List<Product> getProductByName(@PathVariable(value="name") String name){
		
		return (List<Product>) prepo.findByName(name);
	}
	
	
	
	@PostMapping("/products")
    public Product saveProduct(@Validated @RequestBody Product product) {
     return prepo.save(product);
                    
	}
	
	
	@DeleteMapping("/products/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") String pId)
            throws ResourceNotFoundException{
     Product product = prepo.findById(pId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));
        prepo.delete(product);
       
        Map <String, Boolean> response = new HashMap<String, Boolean>();
        response.put("Deleted", Boolean.TRUE);
        return response;
        
    }
	
	@PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") String pId,
            @Validated @RequestBody Product p) throws ResourceNotFoundException {
    
     Product product = prepo.findById(pId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));
    
                   
        product.setBrand(p.getBrand());
        product.setMadein(p.getMadein());
        product.setName(p.getName());
        product.setPrice(p.getPrice());
        product.setCategory(p.getCategory());
       
        final Product updatedProduct = prepo.save(product);
        return ResponseEntity.ok(updatedProduct);
    }
}
