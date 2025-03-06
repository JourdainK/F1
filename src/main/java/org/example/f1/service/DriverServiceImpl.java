package org.example.f1.service;

import org.example.f1.model.Driver;
import org.example.f1.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private DriverRepository driverRepository;

    @Autowired
    public void setDriverRepository(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }


    @Override
    public Iterable<Driver> listAllDrivers() {
        return driverRepository.findAll();
    }


    @Override
    public Driver getDriverById(String id) {
        return driverRepository.getDriverById(id);
    }

    @Override
    public Page<Driver> findAll(Pageable pageable) {
        return driverRepository.findAll(pageable);
    }

    @Override
    public List<Driver> findTop10ByTotalRaceWins() {
        return driverRepository.findTop10ByTotalRaceWins();
    }

    @Override
    public List<Driver> findByLastNameContainingIgnoreCase(String lastName) {
        return driverRepository.findByLastNameContainingIgnoreCase(lastName);
    }

    @Override
    public List<Driver> findByBirthCountry(String country) {
        return driverRepository.findByBirthCountryContainingIgnoreCase(country);
    }

    @Override
    public Page<Driver> findByLastNameContainingIgnoreCase(String lastName, Pageable pageable) {
        return driverRepository.findByLastNameContainingIgnoreCase(lastName, pageable);
    }

    @Override
    public Page<Driver> findByBirthCountry(String country, Pageable pageable) {
        return driverRepository.findByBirthCountryContainingIgnoreCase(country, pageable);
    }



}
