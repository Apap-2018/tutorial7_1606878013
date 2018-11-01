package com.apap.tutorial7.controller;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

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
}
