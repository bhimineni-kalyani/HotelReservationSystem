package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class HotelReservationSystemtest5 {
    private HotelReservationSystem5 hotelReservationSystem5;

    @Before
    public void init() {
        int lakeWoodWeekday = 110;
        int lakeWoodWeekendDay = 90;

        int bridgeWoodWeekday = 150;
        int bridgeWoodWeekendDay = 50;

        int ridgeWoodWeekday = 220;
        int ridgeWoodWeekendDay = 150;

        Hotel lakewood = new Hotel("Lakewood", "Guntur", lakeWoodWeekday, lakeWoodWeekendDay, 3);
        Hotel bridewood = new Hotel("Bridgewood", "Guntur", bridgeWoodWeekday, bridgeWoodWeekendDay, 4);
        Hotel ridgewood = new Hotel("Ridgewood", "Guntur", ridgeWoodWeekday, ridgeWoodWeekendDay, 5);

        hotelReservationSystem5 = new HotelReservationSystem5();
        hotelReservationSystem5.printWelcomeMessage();
        hotelReservationSystem5.add(lakewood);
        hotelReservationSystem5.add(bridewood);
        hotelReservationSystem5.add(ridgewood);
    }

    @Test
    public void givenHotelsInTheSystem_ShowAllTheHotelNames_ShouldReturnProperHotel() {
        String names = hotelReservationSystem5.getHotelNames();
        String expectedNames = "Lakewood Bridgewood Ridgewood";
        Assert.assertEquals(expectedNames, names);
    }

    @Test
    public void givenHotelsInTheSystem_ShouldReturnTheCheapestHotelList_WithinGivenDates() throws InvalidDateExceptions {
        String date1 = "10Sep2020";
        String date2 = "11Sep2020";
        Map<Hotel, Integer> map = hotelReservationSystem5.getCheapestHotels(date1, date2);
        boolean result = false;
        for( Map.Entry<Hotel, Integer> entry : map.entrySet()){
            if(entry.getKey().getName().equals("Lakewood") && entry.getValue().equals(Integer.valueOf(220)))
                result = true;
            System.out.println("Hotel: " + entry.getKey().getName() + "Rate: " + entry.getValue());
        }
        Assert.assertTrue(result);
    }

    @Test
    public void givenHotelsInTheSystem_ShouldReturnItsWeekDayAndWeekendDayRate(){
        String hotelListRates = hotelReservationSystem5.printNameWeekDayAndWeekendRates();
        String expected = "Lakewood Weekday Rate: 110 Weekend Day Rate: 90\n" +
                          "Bridgewood Weekday Rate: 150 Weekend Day Rate: 50\n" +
                          "Ridgewood Weekday Rate: 220 Weekend Day Rate: 150\n";
        System.out.println(hotelListRates);
        Assert.assertEquals(expected, hotelListRates);
    }

    @Test
    public void givenHotelsInTheSystem_ShouldReturnTheCheapestHotelsInTheSystem_WithinGivenRangeOfDate() throws InvalidDateExceptions {
        String date1 = "11Sep2020";
        String date2 = "12Sep2020";
        Map<Hotel, Integer> map = hotelReservationSystem5.getCheapestHotels(date1, date2);
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
        Assert.assertTrue(result1lakewood && rateslakewood && result2bridgewood && ratesbridgewood && tot_size);
    }

    @Test
    public void givenHotelsInTheSystem_ShouldReturnProperRatingsAsAssigned(){
        String result = hotelReservationSystem5.printNamesAndRating();
        String expectedResult = "Lakewood Rating: 3\n" +
                                "Bridgewood Rating: 4\n" +
                                "Ridgewood Rating: 5\n";
        System.out.println(result);
        Assert.assertEquals(expectedResult, result);
    }
}