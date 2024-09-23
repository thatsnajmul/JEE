package com.thatsnajmul.job_sys.service;

import com.thatsnajmul.job_sys.entity.PersonalDetails;
import com.thatsnajmul.job_sys.repository.PersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalDetailsService {

    @Autowired
    private PersonalDetailsRepository personalDetailsRepository;

    public List<PersonalDetails> getAllUsers() {
        return personalDetailsRepository.findAll();
    }

    public PersonalDetails getUserById(Long id) {
        return personalDetailsRepository.findById(id).orElse(null);
    }

    public PersonalDetails createUser(PersonalDetails personalDetails) {
        return personalDetailsRepository.save(personalDetails);
    }

    public PersonalDetails updateUser(Long id, PersonalDetails personalDetails) {
        PersonalDetails existingDetails = personalDetailsRepository.findById(id).orElse(null);
        if (existingDetails != null) {
            existingDetails.setFirstName(personalDetails.getFirstName());
            existingDetails.setLastName(personalDetails.getLastName());
            // ... update other fields as necessary
            return personalDetailsRepository.save(existingDetails);
        }
        return null;
    }

    public void deleteUser(Long id) {
        personalDetailsRepository.deleteById(id);
    }
}
