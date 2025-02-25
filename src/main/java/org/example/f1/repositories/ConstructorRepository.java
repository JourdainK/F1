package org.example.f1.repositories;

import org.example.f1.model.Constructor;
import org.example.f1.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.List;

public interface ConstructorRepository extends JpaRepository<Constructor, String> {
    List<Constructor> getConstructorsByCountry(Country country);
    List<Constructor> findByNameContainingIgnoreCase(String name);

}
