package com.thatsnajmul.job_portal.RestController;

import com.thatsnajmul.job_portal.Entity.UserProfile;
import com.thatsnajmul.job_portal.Service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userprofiles")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("id") Long id, @RequestParam("image") MultipartFile file) throws IOException {
        userProfileService.saveImage(id, file);
        return ResponseEntity.ok("Image uploaded successfully");
    }

    @GetMapping("/get/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        byte[] image = userProfileService.getImageById(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    @PutMapping("/update/{id}/image")
    public ResponseEntity<String> updateImage(@PathVariable Long id, @RequestParam("image") MultipartFile file) throws IOException {
        userProfileService.updateImage(id, file);
        return ResponseEntity.ok("Image updated successfully");
    }

    @DeleteMapping("/delete/{id}/image")
    public ResponseEntity<String> deleteImage(@PathVariable Long id) {
        userProfileService.deleteImage(id);
        return ResponseEntity.ok("Image deleted successfully");
    }
}
