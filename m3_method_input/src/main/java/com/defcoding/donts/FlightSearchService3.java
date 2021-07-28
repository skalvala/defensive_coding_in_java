package com.defcoding.donts;

import com.defcoding.Flight;
import com.defcoding.FlightStore;
import com.defcoding.FlightStoreImpl;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightSearchService3 {

    private FlightStore flightStore;


    public FlightSearchService3(FlightStore store){
        this.flightStore = store;
    }

    public List<Flight> search(String fromDest, String toDest, String departDate, int passengerNum){
        List<Flight> flights = flightStore.getFlights(); // ====> Shift this to after guard clauses!

        // MEH.. CODE CHECKS LOOK CLUTTERED! AND INPUT CHECKS ARE PERFORMED ONE AT A TIME...
        if (fromDest == null) {
            throw new IllegalArgumentException("None of the arguments may be null");
        }

        if (toDest == null) {
            throw new IllegalArgumentException("None of the arguments may be null");
        }

        if (departDate == null) {
            throw new IllegalArgumentException("None of the arguments may be null");
        }

        return flights.stream()
               .filter(f -> f.getFromDest().equals(fromDest))
               .filter(f -> f.getToDest().equals(toDest))
               .filter(f -> f.getDate().equals(departDate))
               .filter(f -> f.getSeatsAvailable() >= passengerNum)
               .collect(toList());
    }

    public static FlightSearchService3 flightSearch(){
        return new FlightSearchService3(new FlightStoreImpl());
    }


}
