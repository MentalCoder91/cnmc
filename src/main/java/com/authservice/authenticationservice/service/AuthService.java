package com.authservice.authenticationservice.service;

import com.authservice.authenticationservice.entity.AuthRequest;
import com.authservice.authenticationservice.entity.AuthResponse;
import com.authservice.authenticationservice.entity.UserVO;
import io.jsonwebtoken.lang.Assert;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {


    private final RestTemplate restTemplate;
    private final JwtUtil jwt;

    @Autowired
    public AuthService(RestTemplate restTemplate,
                       final JwtUtil jwt) {
        this.restTemplate = restTemplate;
        this.jwt = jwt;
    }

    public AuthResponse register(AuthRequest authRequest) {
        //do validation if user already exists
        //authRequest.setPassword(BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt()));

        UserVO userVO = restTemplate.postForObject("http://user-service/users", authRequest, UserVO.class);
        Assert.notNull(userVO, "Failed to register user. Please try again later");

        String accessToken = jwt.generate(userVO, "ACCESS");
        String refreshToken = jwt.generate(userVO, "REFRESH");

        return new AuthResponse(accessToken);

    }

    public AuthResponse loginUser(AuthRequest authRequest){

        UserVO userVO = restTemplate.postForObject("http://bts-service/api/user", authRequest, UserVO.class);
        System.out.println(userVO);
        if(userVO == null){
            throw  new RuntimeException("Error Occured as user not present");
        }

        String accessToken = jwt.generate(userVO, "ACCESS");
        return new AuthResponse(accessToken);

    }



}
