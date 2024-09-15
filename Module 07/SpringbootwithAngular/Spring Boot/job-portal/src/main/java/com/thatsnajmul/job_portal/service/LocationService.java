package com.thatsnajmul.job_portal.service;

import com.thatsnajmul.job_portal.entity.Location;
import com.thatsnajmul.job_portal.restcontroller.LocationRepository;
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

    public  void deleteLocation(long id){
        locationRepository.deleteById(id);
    }

    public  Location findById(long id){
        return   locationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Location Not Foound by this Id"));
    }
}
