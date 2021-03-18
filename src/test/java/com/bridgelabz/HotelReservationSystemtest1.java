package com.bridgelabz;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationSystemtest1 {
    private HotelReservationSystem1 hotelReservationSystem1;

    @Before
    public void init() {
        int lakeWood = 220;
        int bridgeWood = 2000;
        int ridgeWood = 370;

        Hotel lakewood = new Hotel("Lakewood", "Guntur", 220);
        Hotel bridgewood = new Hotel("Bridgewood", "Guntur", 200);
        Hotel ridgewood = new Hotel("Ridgewood", "Guntur", 370);

        hotelReservationSystem1 = new HotelReservationSystem1();
        hotelReservationSystem1.printWelcomeMessage();
        hotelReservationSystem1.add(lakewood);
        hotelReservationSystem1.add(bridgewood);
        hotelReservationSystem1.add(ridgewood);
    }

    @Test
    public void givenHotelsInTheSystem_ShowAllTheHotelNames_ShouldReturnProperHotel() {
        String names = hotelReservationSystem1.getHotelNames();
        String expectedNames = "Lakewood Bridgewood Ridgewood";
        Assertions.assertEquals(expectedNames, names);
    }
}