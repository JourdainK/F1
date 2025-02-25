package org.example.f1.repositories;

import org.example.f1.model.Continent;
import org.example.f1.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByContinentId(Continent continent);
}
