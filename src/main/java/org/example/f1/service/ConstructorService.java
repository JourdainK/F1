package org.example.f1.service;

import org.example.f1.model.Constructor;
import org.example.f1.repositories.ConstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstructorService {
    private final ConstructorRepository constructorRepository;

    public ConstructorService(ConstructorRepository constructorRepository) {
        this.constructorRepository = constructorRepository;
    }

    public List<Constructor> searchByName(String name){
        return constructorRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Constructor> searchByCountryName(String name){
        return constructorRepository.findByCountry_NameContainingIgnoreCase(name);
    }
 }
