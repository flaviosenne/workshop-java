package com.workshop.api.resources;

import java.net.URI;
import java.util.List;

import com.workshop.api.domain.User;
import com.workshop.api.dto.UserDTO;
import com.workshop.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = userService.findById(id);
        return ResponseEntity.status(200).body(UserDTO.builder()
        .id(user.getId())
        .email(user.getEmail())
        .name(user.getName())
        .build());
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        user = userService.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id){
        User user = userService.fromDTO(userDTO);
        user.setId(id);
        user = userService.update(user);
        return ResponseEntity.noContent().build();
    }
}
