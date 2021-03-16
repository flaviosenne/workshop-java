package com.workshop.api.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class CommentDTO implements Serializable {
   
    private static final long serialVersionUID = 1L;
    private String text;
    private Date date;
    private AuthorDTO author;
}
