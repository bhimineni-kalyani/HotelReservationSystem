package com.bridgelabz;

import java.util.Date;

public class Hotel {
    public Integer calculateRate(Date d1, Date d2) {
        Date currentDate = new Date(d1.getDay(), d1.getMonth(), d1.getYear());
        int calculatedRate = 0;
        while(currentDate.isInRange(d1, d2)) {
            calculatedRate += this.rate;
            currentDate.addOneDay();
        }
        return calculatedRate;
    }

    enum CUSTOMER_TYPE {
        REGULAR_TYPE,
        REWARD_TYPE
    }

    private final String name;
    private final String location;
    private final int rate;

    public Hotel(String name, String location, int rate) {
        this.name = name;
        this.location = location;
        this.rate = rate;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public int getRate() {
        return rate;
    }
}