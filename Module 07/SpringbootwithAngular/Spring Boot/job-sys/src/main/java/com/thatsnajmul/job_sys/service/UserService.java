package com.thatsnajmul.job_sys.service;

import com.thatsnajmul.job_sys.entity.User;
import com.thatsnajmul.job_sys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    // This is for authentication purposes
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found With this Email Address"));
    }

    // This method is for retrieving the user profile
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);  // Ensure this method returns Optional<User>
    }



//    // Find user by Email
//    public Optional<User> getUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }

    // Update user by Email
    public User updateUserByEmail(String email, User updatedUser) {
        return userRepository.findByEmail(email).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setCell(updatedUser.getCell());
            user.setAddress(updatedUser.getAddress());
            user.setDob(updatedUser.getDob());
            user.setGender(updatedUser.getGender());
            user.setImage(updatedUser.getImage());
            user.setActive(updatedUser.isActive());
            user.setLock(updatedUser.isLock());
            user.setRole(updatedUser.getRole());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Delete user by Email
    public void deleteUserByEmail(String email) {
        userRepository.findByEmail(email).ifPresent(userRepository::delete);
    }


}
