package com.example.spring_security.userRepository;


import com.example.spring_security.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDomain, Long> {  // 객체타임을 넣어준다.
    boolean existsByUsername(String username);  // 존재하면 true 존재하지 않으면 false 값을 날리는 메소드이다.

    UserDomain findByUsername(String username);

}






