package com.thatsnajmul.job_sys.controller;

// PersonalDetailsController.java
import com.thatsnajmul.job_sys.entity.PersonalDetails;
import com.thatsnajmul.job_sys.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personal-details")
@CrossOrigin("*")
public class PersonalDetailsController {

    @Autowired
    private PersonalDetailsService personalDetailsService;

    // Get all personal details with pagination
    @GetMapping
    public ResponseEntity<Page<PersonalDetails>> getAllPersonalDetails(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(personalDetailsService.getAllPersonalDetails(pageable));
    }

    // Get a specific personal details record by ID
    @GetMapping("/{id}")
    public ResponseEntity<PersonalDetails> getPersonalDetailsById(@PathVariable Long id) {
        return ResponseEntity.ok(personalDetailsService.getPersonalDetailsById(id));
    }

    // Create a new personal details record
    @PostMapping
    public ResponseEntity<PersonalDetails> createPersonalDetails(@RequestBody PersonalDetails personalDetails) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personalDetailsService.createPersonalDetails(personalDetails));
    }

    // Update an existing personal details record
    @PutMapping("/{id}")
    public ResponseEntity<PersonalDetails> updatePersonalDetails(@PathVariable Long id, @RequestBody PersonalDetails personalDetailsDetails) {
        return ResponseEntity.ok(personalDetailsService.updatePersonalDetails(id, personalDetailsDetails));
    }

    // Delete a personal details record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonalDetails(@PathVariable Long id) {
        personalDetailsService.deletePersonalDetails(id);
        return ResponseEntity.noContent().build();
    }

    // Search personal details by first name or last name with pagination
    @GetMapping("/search")
    public ResponseEntity<Page<PersonalDetails>> searchPersonalDetails(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(personalDetailsService.searchPersonalDetails(firstName, lastName, pageable));
    }
}
