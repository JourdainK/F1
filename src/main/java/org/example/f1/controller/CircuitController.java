package org.example.f1.controller;


import org.example.f1.model.Circuit;
import org.example.f1.repositories.CircuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/circuits")
public class CircuitController {

    @Autowired
    private CircuitRepository circuitRepository;


    //TODO save db with all the paths and change data.sql with the backup
    @RequestMapping("/all")
    public String displayAll(Map<String, Object> model){
        try{
            Collection<Circuit> allCircuits = circuitRepository.findAll();
            allCircuits = allCircuits.stream()
                    .sorted(Comparator.comparing(Circuit::getId))
                    .collect(Collectors.toList());
            model.put("allCircuits", allCircuits);
        }catch (Exception e){
            e.printStackTrace();
            model.put("error", e.getMessage());
            return "error";
        }
        return "allCircuits";
    }

}
