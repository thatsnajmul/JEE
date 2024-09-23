package com.thatsnajmul.job_sys.controller;

// PersonalDetailsController.java
import com.thatsnajmul.job_sys.entity.PersonalDetails;
import com.thatsnajmul.job_sys.repository.PersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal-details")
public class PersonalDetailsController {
    @Autowired
    private PersonalDetailsRepository repository;

    @GetMapping
    public List<PersonalDetails> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalDetails> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(details -> ResponseEntity.ok(details))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PersonalDetails> create(@RequestBody PersonalDetails details) {
        return new ResponseEntity<>(repository.save(details), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalDetails> update(@PathVariable Long id, @RequestBody PersonalDetails details) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        details.setId(id);
        return ResponseEntity.ok(repository.save(details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
