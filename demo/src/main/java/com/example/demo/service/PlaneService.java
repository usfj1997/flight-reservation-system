package com.example.demo.service;

import com.example.demo.model.Passenger;
import com.example.demo.model.Plane;
import com.example.demo.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneService {
    @Autowired
    private PlaneRepository planeRepository;
    public List<Plane> getAllPlanes(){ return planeRepository.findAll(); }
    public void savePlanes(Plane plane) {
        this.planeRepository.save(plane);
    }
    public Plane getPlaneByRegistrationNumber(String registration_number) {
        Optional<Plane> optional = planeRepository.findById(registration_number);
        Plane plane = null;
        if (optional.isPresent()){
            plane= optional.get();
        } else {
            throw new RuntimeException("Plane not found for the Registration Number :: " + registration_number);
        }
        return plane;
    }
    public void deletePlaneByRegistrationNumber(String registration_number) {
        this.planeRepository.deleteById(registration_number);
    }
}
