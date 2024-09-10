package com.thatsnajmul.job_portal.Service;

import com.thatsnajmul.job_portal.Entity.AuthenticationResponse;
import com.thatsnajmul.job_portal.Entity.Token;
import com.thatsnajmul.job_portal.Entity.UserEntity;
import com.thatsnajmul.job_portal.Jwt.JwtService;
import com.thatsnajmul.job_portal.Repository.TokenRepository;
import com.thatsnajmul.job_portal.Repository.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;
    private final AuthenticationManager authenticationManager;


    private void saveUserToken(String jwt, UserEntity user) {
        Token token = new Token();
        token.setToken(jwt);
        token.setLoggedOut(false);
        token.setUserEntity(user);

        tokenRepository.save(token);
    }


    private void revokeAllTokenByUser(UserEntity user) {

        List<Token> validTokens = tokenRepository.findAllTokensByUser(user.getId());
        if(validTokens.isEmpty()) {
            return;
        }

        // Set all valid tokens for the user to logged out
        validTokens.forEach(t-> {
            t.setLoggedOut(true);
        });

        // Save the changes to the tokens in the token repository
        tokenRepository.saveAll(validTokens);
    }



    public AuthenticationResponse register(UserEntity request) {

        // Check if the user already exists
        if(userRepository.findByEmail(request.getUsername()).isPresent()) {
            return new AuthenticationResponse(null, "User already exists");
        }

        // Create a new user entity and save it to the database
//        User user = new User();
//        user.setName(request.getName());
//        user.setEmail(request.getEmail());
        request.setPassword(passwordEncoder.encode(request.getPassword()));
//        user.setRole(request.getRole());
//        user.setDob(request.getDob());
//        user.setCell(request);
//        user = userRepository.save(user);
        userRepository.save(request);

        // Generate JWT token for the newly registered user
        String jwt = jwtService.generateToken(request);

        // Save the token to the token repository
        saveUserToken(jwt, request);

        return new AuthenticationResponse(jwt, "User registration was successful");
    }


    // Method to authenticate a user
    public AuthenticationResponse authenticate(UserEntity request) {

        // Authenticate user credentials using Spring Security's AuthenticationManager
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        // Retrieve the user from the database
        UserEntity user = userRepository.findByEmail(request.getUsername()).orElseThrow();

        // Generate JWT token for the authenticated user
        String jwt = jwtService.generateToken(user);

        // Revoke all existing tokens for this user
        revokeAllTokenByUser(user);

        // Save the new token to the token repository
        saveUserToken(jwt, user);


        return new AuthenticationResponse(jwt, "User login was successful");
    }
}
