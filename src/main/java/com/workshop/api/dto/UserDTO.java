package com.workshop.api.dto;

import com.workshop.api.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO {

    private String id;
    private String name;
    private String email;
    

    public UserDTO (User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();

    }
}
