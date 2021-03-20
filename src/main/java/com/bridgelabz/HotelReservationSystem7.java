package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HotelReservationSystem7 {
    private final ArrayList<Hotel> hotelList;
    public HotelReservationSystem7() {
        hotelList = new ArrayList<>();
    }

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

    public Map<Hotel, Integer> getCheapestHotels (String from_date, String to_date) throws InvalidDateExceptions {
        Date d1 = Date.extractDate(from_date);
        Date d2 = Date.extractDate(to_date);
        Map<Hotel, Integer> cheapHotels_andRatesMap = new HashMap<>();
        Integer cheapestRate = Integer.MAX_VALUE;
        for(Hotel hotel : hotelList){
            Integer total_period_rate = hotel.calculateRate(d1, d2);
            int compare = total_period_rate.compareTo(cheapestRate);
            if( compare < 0) {
                cheapHotels_andRatesMap.clear();
                cheapestRate = total_period_rate;
                cheapHotels_andRatesMap.put(hotel, cheapestRate);
            }
            else if(compare == 0) {
                cheapHotels_andRatesMap.put(hotel, total_period_rate);
            }
        }
        return cheapHotels_andRatesMap;
    }

    public String printNameWeekDayAndWeekendRates() {
        StringBuilder hotelListString = new StringBuilder();
        for(Hotel hotel : hotelList) {
            hotelListString.append(hotel.getName()).append(" Weekday Rate: ").append(hotel.getWeekdayRate()).append(" Weekend Day Rate: ").append(hotel.getWeekendDayRate()).append("\n");
        }
        return hotelListString.toString();
    }

    public String printNamesAndRating() {
        StringBuilder hotelListString = new StringBuilder();
        for(Hotel hotel : hotelList)
            hotelListString.append(hotel.getName()).append(" Rating: ").append(hotel.rating()).append("\n");
        return hotelListString.toString();
    }

    public Map<Hotel, Integer> getBestRatedCheapestHotels(String from_date, String to_date) throws InvalidDateExceptions {
        Date d1 = Date.extractDate(from_date);
        Date d2 = Date.extractDate(to_date);
        Map<Hotel, Integer> cheapHotels_andRatesMap = new HashMap<>();
        Integer cheapestRate = Integer.MAX_VALUE;
        Hotel ref_cheapestHotel = null;
        for(Hotel hotel : hotelList){
            Integer total_period_rate = hotel.calculateRate(d1, d2);
            int compare = total_period_rate.compareTo(cheapestRate);
            if( compare < 0) {
                cheapHotels_andRatesMap.clear();
                cheapestRate = total_period_rate;
                ref_cheapestHotel = hotel;
                cheapHotels_andRatesMap.put(hotel, cheapestRate);
            }
            else if(compare == 0) {
                assert ref_cheapestHotel != null;
                if(hotel.rating() > ref_cheapestHotel.rating()) {
                    cheapHotels_andRatesMap.clear();
                    cheapHotels_andRatesMap.put(hotel, total_period_rate);
                }
                else if(hotel.rating() == ref_cheapestHotel.rating()) {
                    cheapHotels_andRatesMap.put(hotel, total_period_rate);
                }
            }
        }
        return cheapHotels_andRatesMap;
    }

    public Map<Hotel, Integer> getBestRatedHotels(String from_date, String to_date) throws InvalidDateExceptions {
        Date d1 = Date.extractDate(from_date);
        Date d2 = Date.extractDate(to_date);
        Map<Hotel, Integer> bestRatedHotels_AndTheirRates = new HashMap<>();
        int rating = -1;
        for(Hotel hotel : hotelList) {
            if(hotel.rating() > rating) {
                bestRatedHotels_AndTheirRates.clear();
                rating = hotel.rating();
                bestRatedHotels_AndTheirRates.put(hotel, hotel.calculateRate(d1, d2));
            }
            else if(hotel.rating() == rating){
                bestRatedHotels_AndTheirRates.put(hotel, hotel.calculateRate(d1, d2));
            }
        }
        return bestRatedHotels_AndTheirRates;
    }
}