package org.example.f1.repositories;

import org.example.f1.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DriverRepository extends JpaRepository<Driver, String> {
}