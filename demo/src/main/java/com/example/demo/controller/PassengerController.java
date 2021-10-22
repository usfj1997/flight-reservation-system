package com.example.demo.controller;

import com.example.demo.model.Passenger;
import com.example.demo.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    //display list of passengers
    @GetMapping("/viewPassenger")
    public String viewPassengers(Model model){
        model.addAttribute("listPassengers", passengerService.getAllPassengers());
        return "index0";
    }

    @GetMapping("/showNewPassengersForm")
    public String showNewPassengersForm(Model model){
        //create model attribute to bind form data
        Passenger passenger = new Passenger();
        model.addAttribute("passenger", passenger);
        return "new_passenger";
    }

    @PostMapping("/savePassenger")
    public String savePassenger(@ModelAttribute("employee") Passenger passenger) {
        //save passenger to database
        passengerService.savePassenger(passenger);
        return "redirect:/viewPassenger";
    }

    @GetMapping("/showFormForUpdate/{passport_number}")
    public String showFormForUpdate(@PathVariable(value = "passport_number") String passport_number, Model model){
        //get passenger from the service
        Passenger passenger = passengerService.getPassengerByPassportNumber(passport_number);

        //set passenger as a model attribute to pre-populate the form
        model.addAttribute("passenger",passenger);
        return "update_passenger";
    }

    @GetMapping("/deletePassenger/{passport_number}")
    public String deletePassenger(@PathVariable(value = "passport_number") String passport_number) {
        //call delete passport method
        this.passengerService.deletePassengerByPassportNumber(passport_number);
        return "redirect:/viewPassenger";
    }
}
