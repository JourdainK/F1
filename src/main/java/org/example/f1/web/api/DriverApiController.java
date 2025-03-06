package org.example.f1.web.api;

import org.example.f1.model.Driver;
import org.example.f1.repositories.DriverRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverApiController {
    public final DriverRepository driverRepository;

    public DriverApiController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @GetMapping
    public List<Driver> getDrivers() { return driverRepository.findAll(); }

    @GetMapping("/name")
    public List<Driver> getDriversByName(@RequestParam String name) { return driverRepository.findByLastNameContainingIgnoreCase(name); }

    @GetMapping("/country")
    public List<Driver> getDriversByCountry(@RequestParam String country) { return driverRepository.findByBirthCountryContainingIgnoreCase(country); }


}
