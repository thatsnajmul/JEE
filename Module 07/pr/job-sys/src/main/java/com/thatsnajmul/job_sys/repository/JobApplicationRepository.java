package com.thatsnajmul.job_sys.repository;

import com.thatsnajmul.job_sys.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    Page<JobApplication> findByExperience(Integer experience, Pageable pageable);
    Page<JobApplication> findByJobIdContainingIgnoreCase(String jobId, Pageable pageable);
}

