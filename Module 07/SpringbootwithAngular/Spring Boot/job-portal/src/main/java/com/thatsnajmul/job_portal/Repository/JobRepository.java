package com.thatsnajmul.job_portal.repository;

import com.thatsnajmul.job_portal.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long> {

}
