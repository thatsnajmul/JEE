package com.thatsnajmul.job_sys.controller;


import com.thatsnajmul.job_sys.entity.AuthenticationResponse;
import com.thatsnajmul.job_sys.entity.User;
import com.thatsnajmul.job_sys.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/register")
public class AuthenticationController {

    private final AuthService authService;

    @PostMapping("/job-seeker")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(authService.registerJobSeeker(request));
    }

    @PostMapping("/admin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(authService.registerAdmin(request));
    }

    @PostMapping("/employer")
    public ResponseEntity<AuthenticationResponse> registerEmployer(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(authService.registerEmployer(request));
    }

    @PostMapping("/register/jobSeeker")
    public ResponseEntity<AuthenticationResponse> registerJobSeeker(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(authService.registerJobSeeker(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }



    @GetMapping("/activate/{id}")
    public ResponseEntity<String> activateUser(@PathVariable("id") int id) {
        String response = authService.activateUser(id);
        return ResponseEntity.ok(response);
    }


}
