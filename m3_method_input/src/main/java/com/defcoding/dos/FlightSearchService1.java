package com.defcoding.dos;

import com.defcoding.Flight;
import com.defcoding.FlightStore;
import com.defcoding.FlightStoreImpl;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightSearchService1 {

    private FlightStore flightStore;


    public FlightSearchService1(FlightStore store){
        this.flightStore = store;
    }

    public List<Flight> search(String fromDest, String toDest, String departDate, int passengerNum){

        // PLACE GUARD CLAUSES AT THE VERY BEGINNING!
        if (fromDest == null || toDest == null || departDate == null) {
            String msg = String.format("You have provided the following arguments, none of them can be null. " +
                    "fromDest: %s, toDest: %s, date: %s", fromDest, toDest, departDate);
            throw new IllegalArgumentException(msg);
        }

        List<Flight> flights = flightStore.getFlights();

        return flights.stream()
               .filter(f -> f.getFromDest().equals(fromDest))
               .filter(f -> f.getToDest().equals(toDest))
               .filter(f -> f.getDate().equals(departDate))
               .filter(f -> f.getSeatsAvailable() >= passengerNum)
               .collect(toList());
    }

    public static FlightSearchService1 flightSearch(){
        return new FlightSearchService1(new FlightStoreImpl());
    }


}
