package com.example.android.quakereport;

public class EarthquakeClass {

    //Method variables
    private String mMagnitude;
    private String mLocation;
    private String mDate;

    //Class constructor
    public EarthquakeClass(String magnitude, String location, String date){
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    //method to get magnitude
    public String getmMagnitude(){
        return mMagnitude;
    }

    //method to get location
    public String getmLocation(){
        return mLocation;
    }

    //method to get date
    public String getmDate(){
        return mDate;
    }
}
