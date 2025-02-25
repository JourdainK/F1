package org.example.f1.controller;


import org.example.f1.model.Constructor;
import org.example.f1.repositories.ConstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/constructors")
public class ConstructorController {
    @Autowired
    private ConstructorRepository constructorRepository;

    @RequestMapping("/all")
    public String displayAll(Map<String, Object> model){
        try{
            Collection<Constructor> allConstructors = constructorRepository.findAll();
            model.put("allConstructors", allConstructors);
        }catch (Exception e){
            System.out.println("Error while searching the constructors" + e.getMessage());
            model.put("error", e.getMessage());

            return "error";
        }

        return "allConstructors";
    }
}
