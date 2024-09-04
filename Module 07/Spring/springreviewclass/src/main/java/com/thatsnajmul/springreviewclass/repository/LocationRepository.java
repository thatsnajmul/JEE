package com.thatsnajmul.springreviewclass.repository;

import com.thatsnajmul.springreviewclass.entity.Hotel;
import com.thatsnajmul.springreviewclass.entity.Location;
import com.thatsnajmul.springreviewclass.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/hotel")
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/save")

    public ResponseEntity<String> saveHotel(
            @RequestPart(value = "hotel")Hotel hotel,
            @RequestParam(value = "image", required = true) MultipartFile file
            )
        hotelService.saveHotel(hotel,file)
}
