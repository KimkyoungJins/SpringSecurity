//package com.example.spring_security.service;
//
//import com.example.spring_security.domain.UserDomain;
//import com.example.spring_security.dto.JoinDTO;
//import com.example.spring_security.userRepository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class JoinService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//
//    public void joinProcess(JoinDTO joinDTO) {
//
//
//
//
//        UserDomain data = new UserDomain();
//
//        data.setUsername(joinDTO.getUsername());
//        data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
//        data.setRole("ROLE_USER");
//
//        userRepository.save(data);
//    }
//}


package com.example.spring_security.service;

import com.example.spring_security.domain.UserDomain;
import com.example.spring_security.dto.JoinDTO;
import com.example.spring_security.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDTO joinDTO) {

        joinDTO.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));

        // db에 이미 존재하는 username을 가진 회원이 존재하는지 확인해야한다.
        UserDomain data = new UserDomain();

        data.setUsername(joinDTO.getUsername());
        data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        data.setRole("ROLE_USER");

        userRepository.save(data);

    }

}
