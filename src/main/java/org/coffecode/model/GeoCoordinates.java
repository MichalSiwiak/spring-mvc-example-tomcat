package org.coffecode.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class GeoCoordinates {

    private double longitude;
    private double latitude;

    public GeoCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public GeoCoordinates() {}

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
