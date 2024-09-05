package com.thatsnajmul.springreviewclass.service;

import com.thatsnajmul.springreviewclass.entity.Hotel;
import com.thatsnajmul.springreviewclass.entity.Location;
import com.thatsnajmul.springreviewclass.repository.HotelRepository;
import com.thatsnajmul.springreviewclass.repository.LocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

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

    @Transactional

    public void saveHotel(Hotel hotel, MultipartFile imageFile) throws IOException {
        Location location = LocationRepository.findById(hotel.getLocation().getId())
                .orElseThrow(()-> new RuntimeException("Location with this Id not Found"));

        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFileName = saveImage(imageFile, hotel);
            hotel.setImage(imageFileName);
        }

        hotel.setLocation(location);
        hotelRepository.save(hotel);
    }

    public void deleteHotelById(Long id) {
        hotelRepository.deleteById(id);
    }

    public Hotel findHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Hotel with this Id not Found"));
    }

    @Transactional
    public void updateHotel(Long id, Hotel updatedHotel, MultipartFile imageFile) throws IOException {
        Hotel exixstingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with this id"));

                //Update hotel details
        exixstingHotel.setName(updatedHotel.getName());
        exixstingHotel.setAddress(updatedHotel.getAddress());
        exixstingHotel.setRating(updatedHotel.getRating());
        exixstingHotel.setMinPrice(updatedHotel.getMinPrice());
        exixstingHotel.setMaxPrice(updatedHotel.getMaxPrice());

        //Update location
        Location location = locationRepository.findById(updatedHotel.getLocation().getId())
                .orElseThrow(()-> new RuntimeException("Location with this Id not Found"));
        exixstingHotel.setLocation(location);

        //Updated image if provided
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFileName = saveImage(imageFile, exixstingHotel);
            exixstingHotel.setImage(imageFileName);
        }
        hotelRepository.save(exixstingHotel);
    }

    public List<Hotel> findHotelByLocationName(String locationName) {
        return hotelRepository.findByLocationName(locationName);
    }

    private String saveImage(MultipartFile file, Hotel hotel) throws IOException {
        Path uploadPath = Paths.get(uploadDirectory+"/hotel");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        //Generate a unique filename
        String fileName = hotel.getName()+"_"+ UUID.randomUUID().toString();
        Path filePath = uploadPath.resolve(fileName);

        //Save the file
        Files.copy(file.getInputStream(), filePath);

        return  fileName;
    }

}
