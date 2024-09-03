package com.thatsnajmul.MySpringBootProject.service;

import com.thatsnajmul.MySpringBootProject.entity.User;
import com.thatsnajmul.MySpringBootProject.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

public class UserService {


    private UserRepository userRepository;

    private EmailService emailService;
    @Value("${image.updload.dir}")
    private String imageUpdloadDir;

    @Transactional
    public void save(User user, MultipartFile imageFile) throws MessagingException, IOException {
        //Save the image if it exists
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = imageFile.getOriginalFilename();
            user.setImage(imageFilename);
        }

        userRepository.save(user);

        //Send registration email
        String toEmail = user.getEmail();
        String subject = "Registration Confirmation";
        String body = String.format("Thanks %s, Stay with us and your \n User Name is %s.", user.getName(), user.getEmail());
        emailService.sendSimpleMessage(toEmail, subject, body);
    }

    private String saveImage(MultipartFile imageFile) throws IOException {
        Path uploadPath = Paths.get(imageUpdloadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        //Generate a unique filename
        String fileName = UUID.randomUUID().toString()+ "_" + imageFile.getOriginalFilename() + ".jpg";
        Path filePath = uploadPath.resolve(fileName);

        //Save the file
        Files.copy(imageFile.getInputStream(), filePath);

        return fileName; //Return the fileName for storing in the database
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User deleteUserById(long id) {
        return userRepository.findById(id).get();
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }


}
