package com.thatsnajmul.job_portal.restcontroller;

import com.thatsnajmul.job_portal.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
