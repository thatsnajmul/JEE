package com.thatsnajmul.MySpringBootProject.repository;

import com.thatsnajmul.MySpringBootProject.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
