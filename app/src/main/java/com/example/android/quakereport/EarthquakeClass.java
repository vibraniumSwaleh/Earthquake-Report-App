package com.example.android.quakereport;

public class EarthquakeClass {

    //Method variables
    private String magnitudeValue;
    private String locationValue;
    private Long timeValue;

    //Class constructor
    public EarthquakeClass(String magnitude, String location, Long time){
        magnitudeValue = magnitude;
        locationValue = location;
        timeValue = time;
    }

    //method to get magnitude
    public String getMagnitude(){
        return magnitudeValue;
    }

    //method to get location
    public String getLocation(){
        return locationValue;
    }

    //method to get date
    public Long getTime(){
        return timeValue;
    }
}
