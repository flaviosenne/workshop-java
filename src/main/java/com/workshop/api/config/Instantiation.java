package com.workshop.api.config;

import java.util.Arrays;

import com.workshop.api.domain.User;
import com.workshop.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        
        
        User maria = new User(null, "Maria Brown", "maria@email.com");
        User alex = new User(null, "Alex Green", "alex@email.com");
        User bob = new User(null, "Bob Grey", "bob@email.com");


        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
    
}
