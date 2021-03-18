package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class HotelReservationSystemtest2 {
    private HotelReservationSystem2 hotelReservationSystem2;

    @Before
    public void init(){
        int lakeWood = 220;
        int bridgeWood = 200;
        int ridgeWood = 370;

        Hotel lakewood = new Hotel("Lakewood", "Guntur", lakeWood);
        Hotel bridgewood = new Hotel("Bridgewood", "Guntur", bridgeWood);
        Hotel ridgewood = new Hotel("Ridgewood", "Guntur", ridgeWood);

        hotelReservationSystem2 = new HotelReservationSystem2();
        hotelReservationSystem2.printWelcomeMessage();
        hotelReservationSystem2.add(lakewood);
        hotelReservationSystem2.add(bridgewood);
        hotelReservationSystem2.add(ridgewood);
    }

    @Test
    public void givenHotelsInTheSystem_ShowAllTheHotelNames_ShouldReturnProperHotel(){
        String names = hotelReservationSystem2.getHotelNames();
        String expectedNames = "Lakewood Bridgewood Ridgewood ";
        Assert.assertEquals(expectedNames, names);
    }

    @Test
    public void givenHotelsInTheSystem_ShouldReturnTheCheapestHotelList_WithinGivenDates() throws InvalidDateExceptions{
        String date1 = "10Sep2020";
        String date2 = "11Sep2020";
        Map<Hotel, Integer> map = hotelReservationSystem2.getCheapestHotels(date1, date2);
        boolean result = false;
        for( Map.Entry<Hotel, Integer> entry : map.entrySet()){
            if(entry.getKey().getName().equals("Lakewood") && entry.getValue().equals(Integer.valueOf(220)))
                result = true;
            System.out.println("Hotel: " + entry.getKey().getName() + "Rate: " + entry.getValue());
        }
        Assertions.assertTrue(result);
    }
}