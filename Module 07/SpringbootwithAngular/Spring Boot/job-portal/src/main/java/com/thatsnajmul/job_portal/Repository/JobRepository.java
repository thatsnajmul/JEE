package com.thatsnajmul.job_portal.repository;

import com.thatsnajmul.job_portal.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long> {
    @Query("SELECT l FROM JobEntity l WHERE l.location.name = :LocationName")
    List<JobEntity> findByLocationName(@Param("jobLocationName") String LocationName);

}
