package com.thatsnajmul.springreviewclass.repository;

import com.thatsnajmul.springreviewclass.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("select r from Room r where r.hotel.name= :hotelName")
    public List<Room> findByHotelByHotelName(@Param("hotelName") String hotelName);

    @Query("select r from r where r.hotel.id= :hotelid")
    public List<Room> findRoomByHotelId(@Param("hotelid") Long hotelid);
}
