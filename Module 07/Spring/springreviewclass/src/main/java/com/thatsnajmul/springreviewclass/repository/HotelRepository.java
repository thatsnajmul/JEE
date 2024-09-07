package com.thatsnajmul.springreviewclass.repository;

import com.thatsnajmul.springreviewclass.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("select h from Hotel h where h.location.name = :locationName")
    List<Hotel> findByLocationName(@Param("locationName") String locationName);
}