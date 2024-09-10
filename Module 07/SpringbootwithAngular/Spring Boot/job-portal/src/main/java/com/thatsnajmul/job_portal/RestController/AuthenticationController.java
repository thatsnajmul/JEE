package com.thatsnajmul.job_portal.RestController;

import com.thatsnajmul.job_portal.Entity.AuthenticationResponse;
import com.thatsnajmul.job_portal.Entity.UserEntity;
import com.thatsnajmul.job_portal.Service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserEntity request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody UserEntity request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
