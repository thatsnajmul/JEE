package com.thatsnajmul.job_portal.Repository;

import com.thatsnajmul.job_portal.Entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<JobEntity, Long>{
}
