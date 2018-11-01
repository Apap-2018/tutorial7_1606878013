package com.apap.tutorial7.service;

import com.apap.tutorial7.model.FlightModel;

import java.sql.Date;
import java.util.List;

public interface FlightService {
    FlightModel addFlight(FlightModel flight);
    FlightModel findFlightById(long id);
    void deleteFlight(FlightModel flight);
    FlightModel updateFlight(FlightModel flight, String origin, String destination, Date time);
    List<FlightModel> getAllFlights();
    FlightModel findFlightByFlightNumber(String flightNumber);
}
