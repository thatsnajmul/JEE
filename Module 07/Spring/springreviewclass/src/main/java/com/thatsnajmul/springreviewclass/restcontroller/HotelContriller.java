package com.thatsnajmul.springreviewclass.restcontroller;


import com.thatsnajmul.springreviewclass.entity.Hotel;
import com.thatsnajmul.springreviewclass.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelContriller {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<String> saveHotel(
            @RequestPart(value = "hotel")Hotel hotel,
            @RequestParam(value = "image", required = true) MultipartFile file

            ) throws IOException {
        hotelService.saveHotel(hotel, file);

        return new ResponseEntity<>("Hotel added successfully with image.", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/h/searchhotel")
    public ResponseEntity<List<Hotel>> findHotelByLocationName(@RequestParam(value = "locationaName") String locationaName) {
        List<Hotel> hotels = hotelService.findHotelByLocationName(locationaName);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Hotel>> findHotelById(@PathVariable int id) {
        try {
            Hotel hotel = hotelService.findHotelById(id);
            return ResponseEntity.ok(hotel);
        } catch (RuntimeException e){
            return new ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
