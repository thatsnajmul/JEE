package com.thatsnajmul.MySpringBootProject.restcontroller;


import com.thatsnajmul.MySpringBootProject.entity.User;
import com.thatsnajmul.MySpringBootProject.service.UserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserRestController {


    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> adduser(
            @RequestPart("user") User user,
            @RequestParam(value = "image", required = false) MultipartFile imageFile) {

        try {
            userService.save(user, imageFile);
            return new ResponseEntity<>("User added successfully with image.", HttpStatus.OK);
        } catch (MessagingException  | IOException e ) {
            return new ResponseEntity<>("Failedto add user: " + e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getuser() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }



}
