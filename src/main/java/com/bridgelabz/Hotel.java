package com.bridgelabz;

public class Hotel {
    private String name;
    private String location;
    private int weekdayRate;
    private int weekendDayRate;

    public void Hotel(String name, String location, int weekdayRate, int weekendDayRate) {
        this.name = name;
        this.location = location;
        this.weekdayRate = weekdayRate;
        this.weekendDayRate = weekendDayRate;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public int getWeekdayRate() {
        return this.weekdayRate;
    }

    public int getWeekendDayRate() {
        return this.weekendDayRate;
    }

    public int calculateRate(com.bridgelabz.Date d1, com.bridgelabz.Date d2) throws InvalidDateExceptions {
        com.bridgelabz.Date currentDate = new com.bridgelabz.Date(d1.getDay(), d1.getMonth(), d1.getYear());
        int calculatedRate = 0;
        while(currentDate.isInRange(d1, d2)){
            if(currentDate.calculateDay().equals(com.bridgelabz.Date.Day.SAT) || currentDate.calculateDay().equals(Date.Day.SUN))
                calculatedRate += this.weekendDayRate;
            else
                calculatedRate += this.weekdayRate;
            currentDate.addOneDay();
        }
        return calculatedRate;
    }
}