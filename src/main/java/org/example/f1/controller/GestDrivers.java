package org.example.f1.controller;

import org.example.f1.model.Driver;
import org.example.f1.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/drivers")
public class GestDrivers {

    @Autowired
    private DriverRepository driverRepository;


    @RequestMapping("/all")
    public String displayAll(Map<String, Object> model) {
        try {
            Collection<Driver> allDrivers = driverRepository.findAll();
            model.put("allDrivers", allDrivers);
        } catch (Exception e) {
            System.out.println("Error while searching the drivers " + e.getMessage());
            model.put("error", e.getMessage());
            return "error";
        }
        return "allDrivers";
    }

    @GetMapping("/search")
    public String searchDrivers(@RequestParam String lastName, Model model) {
    List<Driver> drivers = driverRepository.findByLastName(lastName);
    model.addAttribute("searchResults", drivers);
    model.addAttribute("searchTerm", lastName);
    return "searchResults";
}
    
}