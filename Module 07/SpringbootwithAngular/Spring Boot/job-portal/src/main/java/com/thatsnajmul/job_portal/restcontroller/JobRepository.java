package com.thatsnajmul.job_portal.restcontroller;


import com.thatsnajmul.job_portal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
