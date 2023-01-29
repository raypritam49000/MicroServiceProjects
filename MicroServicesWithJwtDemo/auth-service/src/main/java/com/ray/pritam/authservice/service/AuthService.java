package com.ray.pritam.authservice.service;

import com.ray.pritam.authservice.utils.JwtUtil;
import com.ray.pritam.authservice.vo.AuthRequest;
import com.ray.pritam.authservice.vo.AuthResponse;
import com.ray.pritam.authservice.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private JwtUtil jwt;

    public AuthResponse register(AuthRequest authRequest) {
        //do validation if user already exists
        authRequest.setPassword(BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt()));

        UserVO userVO = restTemplate.postForObject("http://User-Service/users", authRequest, UserVO.class);
        Assert.notNull(userVO, "Failed to register user. Please try again later");

        String accessToken = jwt.generate(userVO, "ACCESS");
        String refreshToken = jwt.generate(userVO, "REFRESH");

        return new AuthResponse(accessToken, refreshToken);

    }
}
