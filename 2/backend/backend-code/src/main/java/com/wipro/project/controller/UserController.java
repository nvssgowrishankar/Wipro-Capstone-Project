package com.wipro.project.controller;

import java.util.List;

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

import com.wipro.project.model.User;
import com.wipro.project.repository.URepository;
import com.wipro.project.repository.UserRepository;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	

	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private URepository ur;
	
	
	@PostMapping("/addUser")
    public String saveBook(@RequestBody User user){
        urepo.save(user);
       
        return "Added Successfully";
    }
 
    @GetMapping("/findAllUsers")
    public List<User> getAdmin() {
       
        return urepo.findAll();
    }
 
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id){
    	
    	urepo.deleteById(id);
       
        return "Deleted Successfully";
    }
    
    @GetMapping("/findByEmail/{email}")
    
    public User findUser(@PathVariable String email){
    	
    	return ur.findByEmail(email);
    }
	

    @PostMapping("/users")
    public Boolean loginUser(@Validated @RequestBody User user)
    {
        Boolean a=false;;
        String email=user.getEmail();
        String password=user.getPassword();
        //System.out.println(email+password);
        User b = ur.findByEmail(email);
        //.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: "));
    //    System.out.println(d.getEmail() +d.getPassword() );
       
        if(email.equals(b.getEmail()) && password.equals(b.getPassword()))
                {
        //    System.out.println(d.getEmail() +d.getPassword() );
            a=true;
           
                }
        return a;
    }
}
