package com.workshop.api.services;

import java.util.List;
import java.util.stream.Collectors;

import com.workshop.api.domain.User;
import com.workshop.api.dto.UserDTO;
import com.workshop.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll(){

        List<User> list = userRepository.findAll();
        List<UserDTO> listDTO =list.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
        return listDTO;
    }

    public User save(User user){
        return userRepository.save(user);
    }
}
