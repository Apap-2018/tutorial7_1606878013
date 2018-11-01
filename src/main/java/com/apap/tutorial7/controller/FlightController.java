package com.apap.tutorial7.controller;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.rest.Setting;
import com.apap.tutorial7.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restExercise() {
        return new RestTemplate();
    }

    @PostMapping(value = "/add")
    public FlightModel addFlightSubmit(@RequestBody FlightModel flight) {
        return flightService.addFlight(flight);
    }

    @PutMapping(value = "/update/{flightId}")
    public String updateFlightSubmit(@PathVariable("flightId") long flightId,
                                     @RequestParam("destination") String destination,
                                     @RequestParam("origin") String origin,
                                     @RequestParam("time") Date time) {
        FlightModel flight = flightService.findFlightById(flightId);
        if (flight.equals(null)){
            return "Couldn't find your flight";
        }

        flightService.updateFlight(flight, destination, origin, time);
        return "flight update success";
    }

    @GetMapping(value = "/view/{flightNumber}")
    public FlightModel viewFlight(@PathVariable("flightNumber") String flightNumber){
        FlightModel flight = flightService.findFlightByFlightNumber(flightNumber);
        return flight;
    }

    @GetMapping(value = "/all")
    public List<FlightModel> viewAllFlight(){
        List<FlightModel> allFlight = flightService.getAllFlights();
        return allFlight;
    }

    @DeleteMapping(value = "/delete/{flightId}")
    public String deleteFlight(@PathVariable("flightId") long id){
        FlightModel flight = flightService.findFlightById(id);
        if (flight == null){
            return "Couldn't find your flight";
        }
        flightService.deleteFlight(flight);
        return "flight has been deleted";
    }

    @GetMapping(value = "/airports/{namaKota}")
    public String getAirports(@PathVariable ("namaKota") String namaKota) throws Exception {
        String path = Setting.exerciseUrl + "&term=" + namaKota + "&country=ID&all_airports=true";
        return restTemplate.getForEntity(path, String.class).getBody();
    }
}
