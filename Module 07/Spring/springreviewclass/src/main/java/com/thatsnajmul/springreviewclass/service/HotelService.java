package com.thatsnajmul.springreviewclass.service;

import com.thatsnajmul.springreviewclass.entity.Hotel;
import com.thatsnajmul.springreviewclass.entity.Location;
import com.thatsnajmul.springreviewclass.repository.HotelRepository;
import com.thatsnajmul.springreviewclass.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Value("src/main/resources/static/images")
    private String uploadDirectory;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public void saveHotel(Hotel hotel, MultipartFile imageFile) throws IOException {
        Location location = LocationRepository.
    }

}
