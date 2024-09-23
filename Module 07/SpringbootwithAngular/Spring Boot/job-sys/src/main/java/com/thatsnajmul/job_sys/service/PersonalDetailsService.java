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
        return personalDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public PersonalDetails createUser(PersonalDetails personalDetails) {
        return personalDetailsRepository.save(personalDetails);
    }



    public PersonalDetails updateUser(Long id, PersonalDetails personalDetails) {
        PersonalDetails existingUser = personalDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existingUser.setFirstName(personalDetails.getFirstName());
        existingUser.setLastName(personalDetails.getLastName());
        existingUser.setGender(personalDetails.getGender());
        // Set other fields...

        return personalDetailsRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        personalDetailsRepository.deleteById(id);
    }
}
