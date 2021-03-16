package com.workshop.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.workshop.api.domain.User;
import com.workshop.api.dto.UserDTO;
import com.workshop.api.repository.UserRepository;
import com.workshop.api.services.exceptions.ObjectNotFoundException;

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

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            throw new ObjectNotFoundException("object not found");
        }

        return user.get();
    }

    public void delete(String id){
        this.findById(id);
        userRepository.deleteById(id);
    }

    public User update(User user){
        Optional<User> newUser = userRepository.findById(user.getId());

        updateData(newUser, user);
        return userRepository.save(newUser.get());
    }

    private void updateData(Optional<User> newUser, User user) {
        newUser.get().setName(user.getName());
        newUser.get().setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        
        return new User(userDTO.getId(), userDTO.getEmail(), userDTO.getName());
       
    }

}
