package org.example.f1.repositories;

import org.example.f1.model.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CircuitRepository extends JpaRepository<Circuit, String> {
    List<Circuit> findByCountry_NameContainingIgnoreCase(String countryName);
}
