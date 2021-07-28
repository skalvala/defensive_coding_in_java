package com.defcoding;

import com.defcoding.entities.Booking;
import com.defcoding.entities.Passenger;

import java.util.Arrays;

public class App {


    public static void main(String[] args){

        new Booking("1234", Arrays.asList(new Passenger()), null);

    }
}
