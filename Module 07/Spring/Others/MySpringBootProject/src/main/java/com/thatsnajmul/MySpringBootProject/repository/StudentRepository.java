package com.thatsnajmul.MySpringBootProject.repository;

import com.thatsnajmul.MySpringBootProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
