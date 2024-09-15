package com.thatsnajmul.job_sys.repository;

import com.thatsnajmul.job_sys.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    Page<Job> findByTitleContainingIgnoreCaseOrCompanyNameContainingIgnoreCase(String title, String companyName, Pageable pageable);
}

