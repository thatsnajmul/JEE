package com.thatsnajmul.job_portal.RestController;

import com.thatsnajmul.job_portal.Entity.JobEntity;
import com.thatsnajmul.job_portal.Repository.JobRepository;
import com.thatsnajmul.job_portal.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
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




    @PostMapping("post")
    public ResponseEntity<JobEntity> createJob(
            @RequestPart("job") JobEntity job,
            @RequestPart("companyImage") MultipartFile companyImage) {

        JobEntity createdJob = jobService.createJob(job, companyImage);
        return ResponseEntity.ok(createdJob);
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
