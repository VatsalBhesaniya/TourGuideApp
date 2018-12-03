package com.example.android.tourguideapp;

import java.io.Serializable;


public class Place implements Serializable {
    private static final int NO_DATA_PROVIDED = -1;
    //Images of the place
    private int[] mImage;
    //Website of the place
    private String mWebsite = Integer.toString(NO_DATA_PROVIDED);
    //Location of the place
    private String mLocation = Integer.toString(NO_DATA_PROVIDED);
    //Name of the place
    private String mPlaceName;
    //Address of the place
    private String mPlaceAddress = Integer.toString(NO_DATA_PROVIDED);
    //Rating of the place
    private double mRating = NO_DATA_PROVIDED;

    /*Create a new Place object for the list of places.
     * @param iamge array are images of the place.
     * @param website is the website url of the place.
     * @param location is the location url of the place.
     * @param placeName is the name of the place.
     * @param placeAddress is the address of the place.
     * @param rating is the rating of the place*/
    public Place(int[] image, String website, String location, String placeName, String placeAddress, double rating) {
        mImage = image;
        mWebsite = website;
        mLocation = location;
        mPlaceName = placeName;
        mPlaceAddress = placeAddress;
        mRating = rating;
    }

    /*Create a new Place object for the list of places.
     * @param iamge array are images of the place.
     * @param location is the location url of the place.
     * @param placeName is the name of the place.
     * @param placeAddress is the address of the place.
     * @param rating is the rating of the place*/
    public Place(int[] image, String location, String placeName, String placeAddress, double rating) {
        mImage = image;
        mLocation = location;
        mPlaceName = placeName;
        mPlaceAddress = placeAddress;
        mRating = rating;
    }

    /*Create a new Place object for the list of places.
     * @param iamge array are images of the place.
     * @param website is the website url of the place.
     * @param placeName is the name of the place.
     * @param rating is the rating of the place*/
    public Place(int[] image, String website, String placeName) {
        mImage = image;
        mWebsite = website;
        mPlaceName = placeName;
    }

    //Get Images of the place
    public int[] getImage() {
        return mImage;
    }

    //Get website url of the place
    public String getWebsite() {
        return mWebsite;
    }

    //Get location url of the place
    public String getLocation() {
        return mLocation;
    }

    //Get name of the place
    public String getPlaceName() {
        return mPlaceName;
    }

    //Get address of the place
    public String getPlaceAddress() {
        return mPlaceAddress;
    }

    //Get rating of the place
    public double getRating() {
        return mRating;
    }

    //Method to check that the Place object has website url or not
    public boolean hasWebsite() {
        return !mWebsite.equals(Integer.toString(NO_DATA_PROVIDED));
    }

    //Method to check that the Place object has location url or not
    public boolean hasLocation() {
        return !mLocation.equals(Integer.toString(NO_DATA_PROVIDED));
    }

    //Method to check that the Place object has location url or not
    public boolean hasAdress() {
        return !mPlaceAddress.equals(Integer.toString(NO_DATA_PROVIDED));
    }

    //Method to check that the Place object has location url or not
    public boolean hasRating() {
        return mRating != NO_DATA_PROVIDED;
    }
}
