package org.example.f1.repositories;

import java.util.List;

import org.example.f1.model.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, String> {
    Page<Driver> findAll(Pageable pageable);
    List<Driver> findByLastNameContainingIgnoreCase(String lastName);
    List<Driver> findByBirthCountryContainingIgnoreCase(String birthCountry);
    Page<Driver> findByLastNameContainingIgnoreCase(String lastName, Pageable pageable);
    Page<Driver> findByBirthCountryContainingIgnoreCase(String birthCountry, Pageable pageable);

    @Query(value = "SELECT * FROM driver ORDER BY total_race_wins DESC LIMIT 10", nativeQuery = true)
    List<Driver> findTop10ByTotalRaceWins();

    Driver getDriverById(String id);
}