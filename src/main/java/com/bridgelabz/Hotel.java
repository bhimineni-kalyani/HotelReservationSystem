package com.bridgelabz;

public class Hotel {
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