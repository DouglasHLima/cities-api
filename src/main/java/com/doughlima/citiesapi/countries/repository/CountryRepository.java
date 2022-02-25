package com.doughlima.citiesapi.countries.repository;


import com.doughlima.citiesapi.countries.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
