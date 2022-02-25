package com.doughlima.citiesapi.cities.resources;

import com.doughlima.citiesapi.cities.entity.City;
import com.doughlima.citiesapi.cities.repository.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CitiesResourses {

    @Autowired
    private CitiesRepository repository;

    @GetMapping
    public Page<City> cities(Pageable page){
        return repository.findAll(page);
    }
}
