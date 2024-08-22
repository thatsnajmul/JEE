package com.thatsnajmul.MySpringBootProject.repository;

import com.thatsnajmul.MySpringBootProject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.ByteBuffer;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


}
