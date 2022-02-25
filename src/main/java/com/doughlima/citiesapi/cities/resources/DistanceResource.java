package com.doughlima.citiesapi.cities.resources;

import com.doughlima.citiesapi.cities.services.DistanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
@Slf4j
public class DistanceResource {

    @Autowired
    private DistanceService service;

    @GetMapping("/by-points")
    public ResponseEntity<Double> byPoints(@RequestParam(name = "from") Long from,
                           @RequestParam(name = "to") Long to){
        log.info("byPoints");
        return ResponseEntity.ok().body(service.distanceByPointsInMiles(from, to));
    }

    @GetMapping("/by-cube")
    public ResponseEntity<Double> byCube(@RequestParam(name = "from") Long from,
                                 @RequestParam(name = "to") Long to){
        log.info("byCube");
        return ResponseEntity.ok().body(service.distanceByCubeInMeters(from, to));
    }

}
