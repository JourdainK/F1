package org.example.f1.controller;

import org.example.f1.model.Driver;
import org.example.f1.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/drivers")
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @RequestMapping("/all")
    public String displayAll(Map<String, Object> model) {
        try {
            List<Driver> allDrivers = (List<Driver>) driverService.listAllDrivers();
            model.put("allDrivers", allDrivers);
        } catch (Exception e) {
            System.out.println("Error while searching the drivers " + e.getMessage());
            model.put("error", e.getMessage());
            return "error";
        }
        return "Drivers/allDrivers";
    }

    @GetMapping("/allDrivers")
        public String displayAllDrivers(Model model, @RequestParam(required = false) String keyword,
        @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
            try{
                List<Driver> allDrivers= new ArrayList<>();
                Pageable paging =  PageRequest.of(page - 1, size);

                Page<Driver> pageDriver = null;
                if(keyword == null || keyword.isEmpty()){
                    pageDriver = driverService.findAll(paging);
                }else if(keyword.equals("lastName")){
                    //TODO filters
                    //pageDriver = driverService.findByLastNameContainingIgnoreCase(keyword,paging);
                }else if(keyword.equals("birthCountry")){
                    //pageDriver = driverService.findByBirthCountry(keyword, paging);
                }
                if(pageDriver != null){
                    allDrivers = pageDriver.getContent();
                    model.addAttribute("allDrivers", allDrivers);
                    model.addAttribute("currentPage", pageDriver.getNumber() + 1);
                    model.addAttribute("totalItems");
                    model.addAttribute("totalPages", pageDriver.getTotalPages());
                    model.addAttribute("pageSize", size);
                }

            }catch (Exception e){
                model.addAttribute("error" , e.getMessage());
                return "error";
            }

            return "Drivers/allDrivers";
    }

    @GetMapping("/search")
    public String searchDrivers(@RequestParam String lastName, Model model) {
    List<Driver> drivers = driverService.findByLastNameContainingIgnoreCase(lastName);
    model.addAttribute("searchResults", drivers);
    model.addAttribute("searchTerm", lastName);
    return "Drivers/searchResults";
    }

    @GetMapping("/search-nationality")
    public String searchDriversByNationality(@RequestParam String birthCountry, Model model) {
        List<Driver> drivers = driverService.findByBirthCountry(birthCountry);
        model.addAttribute("searchResults", drivers);
        model.addAttribute("searchTerm", birthCountry);
        model.addAttribute("searchType", "nationality");

        return "Drivers/searchResults";
    }

    @GetMapping("/top-10-drivers")
    public String displayTop10Drivers(Map<String, Object> model) {
        try{
            List<Driver> drivers = driverService.findTop10ByTotalRaceWins();
            model.put("drivers", drivers);

        }catch (Exception e){
            System.out.println("Error while searching the drivers " + e.getMessage());
            model.put("error", e.getMessage());
        }

        return "Drivers/top10drivers";
    }
    
}