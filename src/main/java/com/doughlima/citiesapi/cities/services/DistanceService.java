package com.doughlima.citiesapi.cities.services;

import com.doughlima.citiesapi.cities.entity.City;
import com.doughlima.citiesapi.cities.repository.CitiesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class DistanceService {

    @Autowired
    CitiesRepository cityRepository;

    public Double distanceByPointsInMiles(Long city1, Long city2){
        log.info("nativePostgresInMiles ({}, {})",city1,city2);
        return cityRepository.distanceByPoints(city1,city2);
    }

    public Double distanceByCubeInMeters(Long city1, Long city2){
        log.info("distanceByCubeInMeters ({}, {})",city1,city2);
        final List<City> cities = cityRepository.findAllById((Arrays.asList(city1,city2)));

        Point p1 = cities.get(0).getGeoLocation();
        Point p2 = cities.get(1).getGeoLocation();
        return cityRepository.distanceByCube(p1.getX(),p1.getY(),p2.getX(),p2.getY());
    }
}
