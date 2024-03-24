package com.example.spring_security.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter         // Entity에 데이터를 넣고 뺄 수 있는 개터세터

public class UserDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String userName;   // String 으로 바꾸니까 되는데?
    private String password;
    private String role;
    private Long Id;


}