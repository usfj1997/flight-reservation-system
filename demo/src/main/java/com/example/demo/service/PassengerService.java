package com.example.demo.service;

import com.example.demo.model.Passenger;
import com.example.demo.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public void savePassenger(Passenger passenger) {
        this.passengerRepository.save(passenger);
    }

    public Passenger getPassengerByPassportNumber(String passport_number) {
        Optional<Passenger> optional = passengerRepository.findById(passport_number);
        Passenger passenger = null;
        if (optional.isPresent()){
            passenger= optional.get();
        } else {
            throw new RuntimeException("Passenger not found for the Passport Number :: " + passport_number);
        }
        return passenger;
    }

    public void deletePassengerByPassportNumber(String passport_number) {
        this.passengerRepository.deleteById(passport_number);
    }
}
