package com.thatsnajmul.job_sys.repository;


import com.thatsnajmul.job_sys.entity.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {
}
