package com.example.spring_security.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter         // Entity에 데이터를 넣고 뺄 수 있는 개터세터

public class UserDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(unique = true)     // 해당 colymn 값이 유니크 해 줄 수 있도록 하는 것이다.

    private String username;   // String 으로 바꾸니까 되는데?
    private String password;
    private String role;
    private Long Id;


}