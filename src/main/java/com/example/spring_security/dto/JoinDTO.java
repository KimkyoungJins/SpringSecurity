package com.example.spring_security.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JoinDTO {

    private Long Id;
    private String username;
    private String password;
    private String role;
}