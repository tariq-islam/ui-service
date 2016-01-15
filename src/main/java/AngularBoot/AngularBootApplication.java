package AngularBoot;

import java.security.Principal;
import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AngularBootApplication {
	
	 @RequestMapping("/user")
	  public Principal user(Principal user) {
	    return user;
	  }
	 
	@RequestMapping("/resource")
	  public Map<String,Object> home() {
	    Map<String,Object> model = new HashMap<String,Object>();
	    model.put("id", UUID.randomUUID().toString());
	    model.put("content", "Hello World");
	    return model;
	  }

    public static void main(String[] args) {
        SpringApplication.run(AngularBootApplication.class, args);
    }
    
}
