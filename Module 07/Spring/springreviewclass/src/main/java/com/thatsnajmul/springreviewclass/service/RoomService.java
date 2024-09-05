package com.thatsnajmul.springreviewclass.service;

import com.thatsnajmul.springreviewclass.entity.Hotel;
import com.thatsnajmul.springreviewclass.entity.Room;
import com.thatsnajmul.springreviewclass.repository.HotelRepository;
import com.thatsnajmul.springreviewclass.repository.RoomRepository;
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
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelRepository hotelRepository;

    @Value("src/main/resources/static/images")
    private String uploadDir;


    public List<Room> getALlRooms() {

        return roomRepository.findAll();

    }


    @Transactional
    public void saveRoom(Room room, MultipartFile imageFile) throws IOException {

        Hotel hotel = hotelRepository.findById(room.getHotel().getId())
                .orElseThrow(() -> new RuntimeException("Hotel With this Id not Found"));

        System.out.println("Hotel "+hotel.toString());

        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = saveImage(imageFile, room);
            room.setImage(imageFilename); // Set the image filename in the user entity
        }

        room.setHotel(hotel);


        roomRepository.save(room);

    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public Room findById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room Not Foound by this Id"));
    }

    public List<Room> findRoomByHotelName(String hotelName) {

        return roomRepository.findByHotelByHotelName(hotelName);

    }

    public List<Room> findRoomByHotelId(Long hotelid) {

        return roomRepository.findRoomByHotelId(hotelid);

    }






    private String saveImage(Multipart file, Room r) throws IOException {
        Path uploadPath = Paths.get(uploadDir + "/room");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }


        // Generate a unique filename
        String filename = r.getRoomType() + "_" + UUID.randomUUID().toString();
        Path filePath = uploadPath.resolve(filename);

        // Save the file
        Files.copy(file.getInputStream(), filePath);

        return filename; // Return the filename for storing in the database
    }
