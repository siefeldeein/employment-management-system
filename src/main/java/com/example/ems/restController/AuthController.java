package com.example.ems.restController;

import com.example.ems.dto.request.LogInRequest;
import com.example.ems.dto.request.RegisterRequest;
import com.example.ems.dto.response.AuthResponse;
import com.example.ems.entity.Role;
import com.example.ems.entity.User;
import com.example.ems.exception.DuplicateResourceException;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.repository.RoleRepository;
import com.example.ems.repository.UserRepository;
import com.example.ems.security.CustomUserDetailsService;
import com.example.ems.security.JwtService;
import com.example.ems.service.AuthService;
import com.example.ems.service.implementation.UserRegistrationFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserRegistrationFacade userRegistrationFacade;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LogInRequest logInRequest){

        return ResponseEntity.ok(authService.login(logInRequest));
    }

   @PostMapping("/register")
   public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest registerRequest){

       return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userRegistrationFacade.register(registerRequest));
   }
}
