package com.example.spring_security.userRepository;


import com.example.spring_security.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDomain, Long> {

}