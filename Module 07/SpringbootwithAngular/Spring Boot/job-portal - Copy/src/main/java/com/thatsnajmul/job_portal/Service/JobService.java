package com.thatsnajmul.job_portal.Service;

import com.thatsnajmul.job_portal.Entity.JobEntity;
import com.thatsnajmul.job_portal.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public JobEntity createJob(JobEntity job, MultipartFile companyImage) {
        // Logic to save the company image to a folder or a database
        // For now, assume we're just storing the file name in the job

        if (companyImage != null && !companyImage.isEmpty()) {
            String imageName = companyImage.getOriginalFilename();
            job.setCompanyImage(imageName);

            // Here you would store the file physically in the file system
            // e.g. Files.copy(companyImage.getInputStream(), path);
        }

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
