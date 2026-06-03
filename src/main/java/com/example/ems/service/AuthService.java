package com.example.ems.service;

import com.example.ems.dto.request.LogInRequest;
import com.example.ems.dto.request.RegisterRequest;
import com.example.ems.dto.response.AuthResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {

    AuthResponse login(LogInRequest request);

    String generateToken(UserDetails userDetails);

//    AuthResponse register(RegisterRequest registerRequest);

}
