package com.thatsnajmul.springreviewclass.service;

import com.thatsnajmul.springreviewclass.entity.Location;
import com.thatsnajmul.springreviewclass.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getALlLocation(){

        return locationRepository.findAll();

    }

    public  void saveLocation(Location l){
        locationRepository
                .save(l);
    }

    public  void deleteLocation(Long id){
        locationRepository.deleteById(id);
    }

    public  Location findById(Long id){
        return   locationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Location Not Foound by this Id"));
    }

}
