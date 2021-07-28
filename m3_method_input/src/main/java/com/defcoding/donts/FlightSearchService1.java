package com.defcoding.donts;

import com.defcoding.Flight;
import com.defcoding.FlightStore;
import com.defcoding.FlightStoreImpl;

import java.util.List;

import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.stream.Collectors.toList;

public class FlightSearchService1 {

    private FlightStore flightStore;


    public FlightSearchService1(FlightStore store){
        this.flightStore = store;
    }

    public List<Flight> search(String fromDest, String toDest, String departDate, int passengerNum){
        List<Flight> flights = flightStore.getFlights();

        // DON'T DO THIS !!!!!

        if (fromDest != null){
            if (toDest != null){
                if (departDate != null) {
                    return flights.stream()
                            .filter(f -> f.getFromDest().equals(fromDest))
                            .filter(f -> f.getToDest().equals(toDest))
                            .filter(f -> f.getDate().equals(departDate))
                            .filter(f -> f.getSeatsAvailable() >= passengerNum)
                            .collect(toList());
                }
                return null; // -----------> Returning null is a bad practice
            }
            return null; // -----------> Returning null is a bad practice
        }
        return null; // -----------> Returning null is a bad practice
    }

    public static FlightSearchService1 flightSearch(){
        return new FlightSearchService1(new FlightStoreImpl());
    }


}
