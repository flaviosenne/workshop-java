package com.workshop.api.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.workshop.api.domain.Post;
import com.workshop.api.repository.PostRepository;
import com.workshop.api.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

   

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);

        if(!post.isPresent()){
            throw new ObjectNotFoundException("object not found");
        }

        return post.get();
    }

    public List<Post> findByTitle(String text){
        // return postRepository.findByTitleContainingIgnoreCase(text);
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){

        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 *1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
    
}
