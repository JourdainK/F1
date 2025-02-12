package org.example.f1.repositories;

import java.util.List;

import org.example.f1.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DriverRepository extends JpaRepository<Driver, String> {
    List<Driver> findByLastName(String lastName);
}