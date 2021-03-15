package com.workshop.api.resources;

import java.util.List;

import com.workshop.api.domain.User;
import com.workshop.api.dto.UserDTO;
import com.workshop.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> list = userService.findAll();

        return ResponseEntity.status(200).body(list);
    }

    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.status(200).body(userService.save(user));
    }
}
