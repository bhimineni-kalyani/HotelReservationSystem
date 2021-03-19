package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class HotelReservationSystemtest4 {
    private HotelReservationSystem4 hotelReservationSystem4;

    @Before
    public void init() {
        int lakeWoodWeekday = 110;
        int lakeWoodWeekendDay = 90;

        int bridgeWoodWeekday = 160;
        int bridgeWoodWeekendDay = 90;

        int ridgeWoodWeekday = 220;
        int ridgeWoodWeekendDay = 150;

        Hotel lakewood = new Hotel("Lakewood", "Guntur", lakeWoodWeekday, lakeWoodWeekendDay);
        Hotel bridgewood = new Hotel("Bridgewood", "Guntur", bridgeWoodWeekday, bridgeWoodWeekendDay);
        Hotel ridgewood = new Hotel("Ridgewood", "Guntur", ridgeWoodWeekday, ridgeWoodWeekendDay);
        hotelReservationSystem4 = new HotelReservationSystem4();
        hotelReservationSystem4.printWelcomeMessage();
        hotelReservationSystem4.add(lakewood);
        hotelReservationSystem4.add(bridgewood);
        hotelReservationSystem4.add(ridgewood);
    }

    @Test
    public void givenHotelsInTheSystem_ShowAllTheHotelNames_ShouldReturnProperHotel() {
        String names = hotelReservationSystem4.getHotelNames();
        String expectedNames = "Lakewood Bridgewood Ridgewood ";
        Assert.assertEquals(expectedNames, names);
    }

    @Test
    public void givenHotelsInTheSystem_ShouldReturnTheCheapestHotelList_WithinGivenDates() throws InvalidDateExceptions {
        String date1 = "10Sep2020";
        String date2 = "11Sep2020";
        Map<Hotel,Integer> map = hotelReservationSystem4.getCheapestHotels(date1, date2);
        boolean result = false;
        for( Map.Entry<Hotel, Integer> entry : map.entrySet()){
            if(entry.getKey().getName().equals("Lakewood") && entry.getValue().equals(Integer.valueOf(220)))
                result = true;
            System.out.println("Hotel: " + entry.getKey().getName() + "Rate: " + entry.getValue());
        }
        Assert.assertTrue(result);
    }

    @Test
    public void givenHotelsInTheSystem_ShouldReturnItsWeekDayAndWeekendDayRate() {
        String hotelListRates = hotelReservationSystem4.printNameRates();
        String expected = "Lakewood Weekday Rate: 110 Weekend Day Rate: 90\n" +
                          "Bridgewood Weekday Rate: 150 Weekend Day Rate: 50\n" +
                          "Ridgewood Weekday Rate: 220 Weekend Day Rate: 150\n";
        System.out.println(hotelListRates);
        Assert.assertEquals(expected, hotelListRates);
    }

    @Test
    public void givenHotelsInTheSystem_ShouldReturnTheCheapestHotelsInTheSystem_WithinGivenRangeOfDate()  throws InvalidDateExceptions{
        String date1 = "11Sep2020";
        String date2 = "12Sep2020";
        Map<Hotel,Integer> map = hotelReservationSystem4.getCheapestHotels(date1, date2);
        boolean result1lakewood = false, result2bridgewood = false;
        boolean rateslakewood = false, ratesbridgewood = false;
        boolean tot_size = false;
        int size = 0;
        for(Map.Entry<Hotel, Integer> entry : map.entrySet()) {
            if(entry.getKey().getName().equals("Lakewood") && entry.getValue().equals(Integer.valueOf(200))){
                result1lakewood = true;
                rateslakewood = true;
            }
            if(entry.getKey().getName().equals("Bridgewood") && entry.getValue().equals(Integer.valueOf(200))){
                result2bridgewood = true;
                ratesbridgewood = true;
            }
            System.out.println("Name : " + entry.getKey().getName() + " Rate: " + entry.getValue());
            size++;
        }
        tot_size = (size == 2);
        Assert.assertTrue(result1lakewood && rateslakewood
                && result2bridgewood && ratesbridgewood && tot_size);
    }
}