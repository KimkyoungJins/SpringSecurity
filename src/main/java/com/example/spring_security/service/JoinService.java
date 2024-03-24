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
    private BCryptPasswordEncoder bCryptPasswordEncoder;        // 자동으로 주입 받는다. 시큐리티에서 기본적으로 제공하는 암호와 클래스

    public void joinProcess(JoinDTO joinDTO) {      // Dto객체에 담긴 정보를 전단한다고 볼 수 있다.


        //사용자가 입력한 비밀번호를 bCryPasswordEncoder을 이용하여 암호화 한 후
        // 다시 joinDto 업데이트 한다.
        joinDTO.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));

        // db에 이미 존재하는 username을 가진 회원이 존재하는지 확인해야한다.
        boolean isUser = userRepository.existsByUsername(joinDTO.getUsername());

        if (isUser) {
            return;         // 존재한다면 강제롷 함수를 리턴시킨다.
        }



        UserDomain data = new UserDomain();


        //왜냐하면 DTO에 있는 데이터 타입을 Userdomain 형식으로 바꾸기 대문이지
        data.setId(joinDTO.getId());
        data.setUsername(joinDTO.getUsername());
        data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));    // Join dto의 비밀번호 데이터를 그대로 가져옴 그리고 나서 암호화를 시킨다.
        data.setRole("ROLE_ADMIN");


        // 설정된 Userdomain 객체를 user repositor를 통해서 데이터 베이스에 저장한다.
        userRepository.save(data);

    }

}
