package com.thatsnajmul.student.repository;


import com.thatsnajmul.student.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<student, Long> {
}

