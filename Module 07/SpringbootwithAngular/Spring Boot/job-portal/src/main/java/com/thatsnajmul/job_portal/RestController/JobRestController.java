package com.thatsnajmul.job_portal.RestController;

import com.thatsnajmul.job_portal.Entity.JobEntity;
import com.thatsnajmul.job_portal.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from Angular
public class JobRestController {
    @Autowired
    private JobService jobService;

    @GetMapping("get-jobs")
    public List<JobEntity> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public JobEntity getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @PostMapping("post-jobs")
    public JobEntity createJob(@RequestBody JobEntity job) {
        return jobService.createJob(job);
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
