package com.example.demo.controller;

import com.example.demo.model.Passenger;
import com.example.demo.model.Plane;
import com.example.demo.service.PassengerService;
import com.example.demo.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlaneController {
    @Autowired
    private PlaneService planeService;

    //display list of planes
    @GetMapping("/viewPlane")
    public String viewPlanes(Model model){
        model.addAttribute("listPlanes", planeService.getAllPlanes());
        return "index2";
    }

    @GetMapping("/showNewPlanesForm")
    public String showNewPlanesForm(Model model){
        //create model attribute to bind form data
        Plane plane = new Plane();
        model.addAttribute("plane", plane);
        return "new_plane";
    }

    @PostMapping("/savePlane")
    public String savePlane(@ModelAttribute("plane") Plane plane) {
        //save plane to database
        planeService.savePlanes(plane);
        return "redirect:/viewPlane";
    }

    @GetMapping("/showPlaneFormForUpdate/{registration_number}")
    public String showPlaneFormForUpdate(@PathVariable(value = "registration_number") String registration_number, Model model){
        //get plane from the service
        Plane plane = planeService.getPlaneByRegistrationNumber(registration_number);

        //set passenger as a model attribute to pre-populate the form
        model.addAttribute("plane",plane);
        return "update_plane";
    }

    @GetMapping("/deletePlane/{registration_number}")
    public String deletePlane(@PathVariable(value = "registration_number") String registration_number) {
        //call delete plane method
        this.planeService.deletePlaneByRegistrationNumber(registration_number);
        return "redirect:/viewPlane";
    }
}
