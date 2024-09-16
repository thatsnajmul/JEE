package com.thatsnajmul.job_portal.Service;
import com.thatsnajmul.job_portal.Entity.UserProfile;
import com.thatsnajmul.job_portal.Repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import com.thatsnajmul.job_portal.Exception.ResourceNotFoundException;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    public void saveImage(Long id, MultipartFile file) throws IOException {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException ("User not found"));
        userProfile.setImage(file.getBytes());
        userProfileRepository.save(userProfile);
    }

    public byte[] getImageById(Long id) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return userProfile.getImage();
    }

    public void updateImage(Long id, MultipartFile file) throws IOException {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userProfile.setImage(file.getBytes());
        userProfileRepository.save(userProfile);
    }

    public void deleteImage(Long id) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userProfile.setImage(null);
        userProfileRepository.save(userProfile);
    }
}
