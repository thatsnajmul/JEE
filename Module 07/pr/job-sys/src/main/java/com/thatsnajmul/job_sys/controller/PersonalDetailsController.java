package com.thatsnajmul.job_sys.controller;

import com.thatsnajmul.job_sys.entity.PersonalDetails;
import com.thatsnajmul.job_sys.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal-details")
public class PersonalDetailsController {

    @Autowired
    private PersonalDetailsService personalDetailsService;

    @GetMapping
    public List<PersonalDetails> getAllUsers() {
        return personalDetailsService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalDetails> getUserById(@PathVariable Long id) {
        PersonalDetails personalDetails = personalDetailsService.getUserById(id);
        return ResponseEntity.ok(personalDetails);
    }

    @PostMapping
    public PersonalDetails createUser(@RequestBody PersonalDetails personalDetails) {
        return personalDetailsService.createUser(personalDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalDetails> updateUser(@PathVariable Long id, @RequestBody PersonalDetails personalDetails) {
        PersonalDetails updatedDetails = personalDetailsService.updateUser(id, personalDetails);
        return ResponseEntity.ok(updatedDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        personalDetailsService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

