package com.example.android.quakereport;

public class EarthquakeClass {

    //Method variables
    private Double magnitudeValue;
    private String locationValue;
    private Long timeValue;
    private String uRL;

    //Class constructor
    public EarthquakeClass(Double magnitude, String location, Long time, String url){
        magnitudeValue = magnitude;
        locationValue = location;
        timeValue = time;
        uRL = url;
    }

    //method to get magnitude
    public Double getMagnitude(){
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

    //method to get url
    public String getUrl(){
        return uRL;
    }
}
