package com.workshop.api.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.workshop.api.domain.Post;
import com.workshop.api.domain.User;
import com.workshop.api.repository.PostRepository;
import com.workshop.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();    
        postRepository.deleteAll();    
        
        User maria = new User(null, "Maria Brown", "maria@email.com");
        User alex = new User(null, "Alex Green", "alex@email.com");
        User bob = new User(null, "Bob Grey", "bob@email.com");


        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acrodei Feliz hoje", maria);
       
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));

    }
    
}
