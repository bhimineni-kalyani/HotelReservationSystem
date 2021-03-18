package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class HotelReservationSystemtest3 {
    private HotelReservationSystem3 hotelReservationSystem3;

    @Before
    public void init() {
        int lakeWoodWeekday = 110;
        int lakeWoodWeekendDay = 90;

        int bridgeWoodWeekday = 150;
        int bridgeWoodWeekendDay = 50;

        int ridgeWoodWeekday = 220;
        int ridgeWoodWeekendDay = 150;


        Hotel lakewood = new Hotel("Lakewood", "Guntur", lakeWoodWeekday, lakeWoodWeekendDay);
        Hotel bridgewood = new Hotel("Bridgewood", "Guntur", bridgeWoodWeekday, bridgeWoodWeekendDay);
        Hotel ridgewood = new Hotel("Ridgewood", "Guntur", ridgeWoodWeekday, ridgeWoodWeekendDay);

        hotelReservationSystem3 = new HotelReservationSystem3();
        hotelReservationSystem3.printWelcomeMessage();
        hotelReservationSystem3.add(lakewood);
        hotelReservationSystem3.add(bridgewood);
        hotelReservationSystem3.add(ridgewood);
    }

    @Test
    public void givenHotelsInTheSystem_ShowAllTheHotelNames_ShouldReturnProperHotel() {
        String names = hotelReservationSystem3.getHotelNames();
        String expectedNames = "Lakewood Bridgewood Ridgewood";
        Assert.assertEquals(expectedNames, names);
    }

    @Test
    public void givenHotelsInTheSystem_ShouldReturnTheCheapestHotelList_WithinGivenDates() throws InvalidDateExceptions {
        String date1 = "10Sep2020";
        String date2 = "11Sep2020";
        Map<Hotel, Integer> map = hotelReservationSystem3.getCheapestHotels(date1, date2);
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
        String hotelListRates = hotelReservationSystem3.printNameRates();
        String expected = "Lakewood Weekday Rate: 110 Weekend Day Rate: 90\n" +
                          "Bridgewood Weekday Rate: 150 Weekend Day Rate: 50\n" +
                          "Ridgewood Weekday Rate: 220 Weekend Day Rate: 150\n";
        System.out.println(hotelListRates);
        Assert.assertEquals(expected, hotelListRates);
    }
}