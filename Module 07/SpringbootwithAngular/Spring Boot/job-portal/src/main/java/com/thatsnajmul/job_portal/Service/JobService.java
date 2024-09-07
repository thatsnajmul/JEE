package com.thatsnajmul.job_portal.Service;

import com.thatsnajmul.job_portal.Entity.JobEntity;
import com.thatsnajmul.job_portal.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> getAllJobs() {
        return jobRepository.findAll();
    }

    public JobEntity getJobById(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));
    }

    public JobEntity createJob(JobEntity job) {
        return jobRepository.save(job);
    }

    public JobEntity updateJob(Long id, JobEntity updatedJob) {
        JobEntity job = getJobById(id);
        job.setJobTitle(updatedJob.getJobTitle());
        job.setCompanyName(updatedJob.getCompanyName());
        job.setJobType(updatedJob.getJobType());
        job.setJobLocation(updatedJob.getJobLocation());
        job.setJobExperience(updatedJob.getJobExperience());
        job.setJobMinSalary(updatedJob.getJobMinSalary());
        job.setJobMaxSalary(updatedJob.getJobMaxSalary());
        job.setJobCategory(updatedJob.getJobCategory());
        job.setJobDeadline(updatedJob.getJobDeadline());
        job.setCompanyImage(updatedJob.getCompanyImage());
        job.setJobDescription(updatedJob.getJobDescription());
        return jobRepository.save(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
