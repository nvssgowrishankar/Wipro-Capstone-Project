package com.wipro.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.project.model.Retailer;
import com.wipro.project.repository.RRepository;
import com.wipro.project.repository.RetailerRepository;


@RestController
@RequestMapping("/retailer")
@CrossOrigin(origins="http://localhost:4200")
public class RetailerController {
	

	@Autowired
	private RetailerRepository repo;
	
	@Autowired
	private RRepository rr;
	
	
	@PostMapping("/addRetailer")
    public String saveBook(@RequestBody Retailer retailer){
        repo.save(retailer);
       
        return "Added Successfully";
    }
 
    @GetMapping("/findAllRetailers")
    public List<Retailer> getRetailer() {
       
        return repo.findAll();
    }
 
    @DeleteMapping("/delete/{id}")
    public String deleteRetailer(@PathVariable String id){
    	
    	repo.deleteById(id);
       
        return "Deleted Successfully";
    }
    
    @GetMapping("/findById/{id}")
    
    public Optional<Retailer> findRetailer(@PathVariable String id){
    	return repo.findById(id);
    }
	
    @PostMapping("/retailers")
    public Boolean loginRetailer(@Validated @RequestBody Retailer retailer)
    {
        Boolean a=false;;
        String email=retailer.getEmail();
        String password=retailer.getPassword();
        //System.out.println(email+password);
        Retailer b = rr.findByEmail(email);//.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: "));
    //    System.out.println(d.getEmail() +d.getPassword() );
       
        if(email.equals(b.getEmail()) && password.equals(b.getPassword()))
                {
        //    System.out.println(d.getEmail() +d.getPassword() );
            a=true;
           
                }
        return a;
    }

}
