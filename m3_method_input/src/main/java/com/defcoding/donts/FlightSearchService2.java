package com.defcoding.donts;

import com.defcoding.Flight;
import com.defcoding.FlightStore;
import com.defcoding.FlightStoreImpl;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightSearchService2 {

    private FlightStore flightStore;


    public FlightSearchService2(FlightStore store){
        this.flightStore = store;
    }

    public List<Flight> search(String fromDest, String toDest, String departDate, int passengerNum){
        List<Flight> flights = flightStore.getFlights();

        // Better than attempt 1. But not ideal. See slides 15 & 16 of validating-method-input-slides.pdf
        if (fromDest != null && toDest != null && departDate != null) {
                    return flights.stream()
                            .filter(f -> f.getFromDest().equals(fromDest))
                            .filter(f -> f.getToDest().equals(toDest))
                            .filter(f -> f.getDate().equals(departDate))
                            .filter(f -> f.getSeatsAvailable() >= passengerNum)
                            .collect(toList());
        } else {
            throw new IllegalArgumentException("None of the arguments may be null");
        }
    }

    public static FlightSearchService2 flightSearch(){
        return new FlightSearchService2(new FlightStoreImpl());
    }


}
