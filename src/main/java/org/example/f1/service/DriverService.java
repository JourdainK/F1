package org.example.f1.service;

import org.example.f1.model.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DriverService {
    Iterable<Driver> listAllDrivers();
    List<Driver> findByLastNameContainingIgnoreCase(String lastName);
    List<Driver> findByBirthCountry(String country);
    Driver getDriverById(String id);
    Page<Driver> findAll(Pageable pageable);
    List<Driver> findTop10ByTotalRaceWins();
}
