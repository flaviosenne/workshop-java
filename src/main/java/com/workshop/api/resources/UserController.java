package com.workshop.api.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.workshop.api.domain.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @GetMapping
    public List<User> findAll(){
        User maria = new User(1, "Maria Brown", "maria@email.com");
        User alex = new User(2, "Alex Green", "alex@email.com");
         List<User> list = new ArrayList<>();
         list.addAll(Arrays.asList(maria, alex));

         return list;
    }
}
