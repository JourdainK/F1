package org.example.f1.controller;


import org.example.f1.model.Constructor;
import org.example.f1.repositories.ConstructorRepository;
import org.example.f1.service.ConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/constructors")
public class ConstructorController {
    private final ConstructorService constructorService;
    private final ConstructorRepository constructorRepository;

    @Autowired
    public ConstructorController(ConstructorService constructorService, ConstructorRepository constructorRepository) {
        this.constructorService = constructorService;
        this.constructorRepository = constructorRepository;
    }

    @GetMapping("/search")
    public String searchConstructors(@RequestParam String name, Model model) {
        List<Constructor> results = constructorService.searchByName(name);
        model.addAttribute("searchTerm", name);
        model.addAttribute("searchResults", results);
        return "Constructor/constructorSearchResults";
    }

    @GetMapping("/search-country")
    public String searchConstructorsByCountry(@RequestParam String countryName, Model model){
        List<Constructor> results = constructorService.searchByCountryName(countryName);
        model.addAttribute("searchResults", results);
        model.addAttribute("searchTerm", countryName);
        model.addAttribute("searchType","countryName");

        return "Constructor/constructorSearchResults";

    }

    @RequestMapping("/all")
    public String displayAll(Map<String, Object> model) {
        try {
            Collection<Constructor> allConstructors = constructorRepository.findAll();
            model.put("allConstructors", allConstructors);
        } catch (Exception e) {
            System.out.println("Error while searching the constructors" + e.getMessage());
            model.put("error", e.getMessage());
            return "error";
        }
        return "Constructor/allConstructors";
    }


}