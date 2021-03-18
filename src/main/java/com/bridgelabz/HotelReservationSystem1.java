package com.bridgelabz;

import java.util.ArrayList;

public class HotelReservationSystem1 {
    private ArrayList<Hotel> hotelList;

    public void add(Hotel h) {
        hotelList.add(h);
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Hotel Reservation Program");
    }

    public String getHotelNames() {
        StringBuilder names = new StringBuilder();
        for(Hotel h : hotelList)
            names.append(h.getName()).append(" ");
        return names.toString();
    }
}