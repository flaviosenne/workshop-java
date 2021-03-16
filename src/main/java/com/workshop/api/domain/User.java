package com.workshop.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode

@Document(collection = "user")
public class User implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String name;

    private String email;

    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();


    public User(String id, String email, String name){
        this.id = id;
        this.email = email;
        this.name = name;
    }
}
