package com.thatsnajmul.job_portal.RestController;

import com.thatsnajmul.job_portal.Entity.JobEntity;
import com.thatsnajmul.job_portal.Repository.JobRepository;
import com.thatsnajmul.job_portal.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from Angular
public class JobRestController {
    @Autowired
    private JobService jobService;
    private JobRepository jobRepository;

    @GetMapping("get-jobs")
    public List<JobEntity> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public JobEntity getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @GetMapping("/get-jobs")
    public List<JobEntity> getAllJobs(
            @RequestParam(value = "jobType", required = false) String jobType,
            @RequestParam(value = "experience", required = false) String experience,
            @RequestParam(value = "category", required = false) String category) {

        return jobService.getJobs(jobType, experience, category);
    }



    @PostMapping("add-jobs")
    public ResponseEntity<JobEntity> addJob(
            @RequestParam("jobTitle") String jobTitle,
            @RequestParam("companyName") String companyName,
            @RequestParam("jobType") String jobType,
            @RequestParam("jobLocation") String jobLocation,
            @RequestParam("jobExperience") String jobExperience,
            @RequestParam("jobMinSalary") String jobMinSalary,
            @RequestParam("jobMaxSalary") String jobMaxSalary,
            @RequestParam("jobCategory") String jobCategory,
            @RequestParam("jobDeadline") String jobDeadline,
            @RequestParam("jobDescription") String jobDescription,
            @RequestParam("companyImage") MultipartFile companyImage) {

        // Upload the image to a folder and get the path
        String imagePath = saveImage(companyImage);

        JobEntity newJob = new JobEntity();
        newJob.setJobTitle(jobTitle);
        newJob.setCompanyName(companyName);
        newJob.setJobType(jobType);
        newJob.setJobLocation(jobLocation);
        newJob.setJobExperience(jobExperience);
        newJob.setJobMinSalary(jobMinSalary);
        newJob.setJobMaxSalary(jobMaxSalary);
        newJob.setJobCategory(jobCategory);
        newJob.setJobDeadline(jobDeadline);
        newJob.setJobDescription(jobDescription);
        newJob.setCompanyImage(imagePath); // Save the image path

        JobEntity savedJob = jobRepository.save(newJob);
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    // Save the image to the server and return the path
    private String saveImage(MultipartFile file) {
        String folderPath = "resources/uploads/images/jobs";
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(folderPath + fileName);

        try {
            Files.createDirectories(Paths.get(folderPath)); // Ensure folder exists
            Files.write(filePath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath.toString();
    }



    @PutMapping("/{id}")
    public JobEntity updateJob(@PathVariable Long id, @RequestBody JobEntity job) {
        return jobService.updateJob(id, job);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }
}
