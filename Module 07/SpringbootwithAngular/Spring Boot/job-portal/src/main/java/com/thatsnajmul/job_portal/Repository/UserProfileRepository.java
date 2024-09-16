package com.thatsnajmul.job_portal.Repository;


import com.thatsnajmul.job_portal.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
