package com.apap.tutorial7.service;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.repository.FlightDb;
import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.repository.FlightDb;
import com.apap.tutorial7.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDb flightDb;

    @Override
    public FlightModel addFlight(FlightModel flight) {
        flightDb.save(flight);
        return flight;
    }

    @Override
    public FlightModel findFlightById(long id) {
        return flightDb.getOne(id);
    }

    @Override
    public void deleteFlight(FlightModel flightModel) {
        flightDb.delete(flightModel);
    }

    @Override
    public void updateFlight(FlightModel flight, String flightNumber, String origin, String destination, Date time) {
        flight.setFlightNumber(flightNumber);
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setTime(time);
        flightDb.save(flight);
    }

    @Override
    public List<FlightModel> getAllFlights() {
        return flightDb.findAll();
    }

    @Override
    public List<FlightModel> findFlightByName(String flightNumber) {
        return flightDb.findFlightByFlightNumber(flightNumber);
    }
}