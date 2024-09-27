package com.thatsnajmul.job_sys.repository;

import com.thatsnajmul.job_sys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccessRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // For finding a user by email for authentication
}

