package com.thatsnajmul.job_portal.service;

import com.thatsnajmul.job_portal.entity.Job;
import com.thatsnajmul.job_portal.entity.Location;
import com.thatsnajmul.job_portal.restcontroller.JobRepository;
import com.thatsnajmul.job_portal.restcontroller.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Value("src/main/resources/static/images")
    private String uploadDir;


    public List<Job> getAllJob() {

        return jobRepository.findAll();
    }


    @Transactional
    public void saveJob(Job job, MultipartFile imageFile) throws IOException {


        // Fetch job from repository based on the provided ID
        Location location = locationRepository.findById((long) job.getLocation().getId())
                .orElseThrow(() -> new RuntimeException("Location with this ID not found"));

        System.out.println(location.toString());

        // Check if the image file is provided and not empty
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = saveImage(imageFile, job);
            job.setCompanyImage(imageFilename); // Set the image filename in the hotel entity
        }

        // Set the fetched location to the hotel
        job.setLocation(location);

        // Save the hotel to the repository
        jobRepository.save(job);
    }


    public void deleteJobById(long id) {

        jobRepository.deleteById(id);

    }

    public Job findJobById(long id) {

        return jobRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Job Not found With this ID")
                );
    }


    @Transactional
    public void updateJob(long id, Job updatedJob, MultipartFile imageFile) throws IOException {
        Job existingJob = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with this ID"));

        // Update job details
        existingJob.setJobTitle(updatedJob.getJobTitle());
        existingJob.setCompanyName(updatedJob.getCompanyName());
        existingJob.setJobType(updatedJob.getJobType());
        existingJob.setJobLocation(updatedJob.getJobLocation());
        existingJob.setJobExperience(updatedJob.getJobExperience());
        existingJob.setJobMinSalary(updatedJob.getJobMinSalary());
        existingJob.setJobMaxSalary(updatedJob.getJobMaxSalary());
        existingJob.setJobCategory(updatedJob.getJobCategory());
        existingJob.setJobDeadline(updatedJob.getJobDeadline());
        existingJob.setCompanyImage(updatedJob.getCompanyImage());
        existingJob.setJobDescription(updatedJob.getJobDescription());

        // Update location
        Location location = locationRepository.findById(updatedJob.getLocation().getId())
                .orElseThrow(() -> new RuntimeException("Location with this ID not found"));
        existingJob.setLocation(location);

        // Update image if provided
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = saveImage(imageFile, existingJob);
            existingJob.setCompanyImage(imageFilename);
        }

        jobRepository.save(existingJob);
    }


    public List<Job> findJobsByLocationName(String locationName) {

        return jobRepository.findJobsByLocationName(locationName);
    }


    private String saveImage(MultipartFile file, Job j) throws IOException {
        Path uploadPath = Paths.get(uploadDir + "/job");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generate a unique filename
        String filename = j.getCompanyName() + "_" + UUID.randomUUID().toString();
        Path filePath = uploadPath.resolve(filename);

        // Save the file
        Files.copy(file.getInputStream(), filePath);

        return filename; // Return the filename for storing in the database
    }

}
