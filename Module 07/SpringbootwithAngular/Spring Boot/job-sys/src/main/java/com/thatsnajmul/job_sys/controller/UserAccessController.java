package com.thatsnajmul.job_sys.controller;

import com.thatsnajmul.job_sys.entity.User;
import com.thatsnajmul.job_sys.service.UserAccessService;
import com.thatsnajmul.job_sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/access/users")
public class UserAccessController {

    @Autowired
    private UserAccessService userAccessService;

    // GET all users
    @GetMapping
    public List<User> getAllUsers() {
        return userAccessService.getAllUsers();
    }

    // GET a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userAccessService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST - Create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userAccessService.createUser(user));
    }

    // PUT - Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userAccessService.updateUser(id, userDetails);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userAccessService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}

