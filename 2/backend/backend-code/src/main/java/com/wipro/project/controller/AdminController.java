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

import com.wipro.project.model.Admin;
import com.wipro.project.repository.ARepository;
import com.wipro.project.repository.AdminRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
	

	@Autowired
	private AdminRepository arepo;
	
	@Autowired
	private ARepository ar;
	
	
	@PostMapping("/addAdmin")
    public String saveBook(@RequestBody Admin admin){
        arepo.save(admin);
       
        return "Added Successfully";
    }
 
    @GetMapping("/findAllAdmin")
    public List<Admin> getAdmin() {
       
        return arepo.findAll();
    }
 
    @DeleteMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable String id){
    	
    	arepo.deleteById(id);
       
        return "Deleted Successfully";
    }
    
    @GetMapping("/findById/{id}")
    
    public Optional<Admin> findAdmin(@PathVariable String id){
    	return arepo.findById(id);
    }
    
    @PostMapping("/Admins")
    public Boolean loginAdmin(@Validated @RequestBody Admin admin)
    {
        Boolean a=false;;
        String email=admin.getEmail();
        String password=admin.getPassword();
        //System.out.println(email+password);
        Admin b = ar.findByEmail(email);
       
        if(email.equals(b.getEmail()) && password.equals(b.getPassword()))
                {
        //    System.out.println(d.getEmail() +d.getPassword() );
            a=true;
           
                }
        return a;
    }
	

}