package org.coffecode.controller;

import java.net.MalformedURLException;
import java.net.URL;

import org.coffecode.model.GeoCoordinates;
import org.coffecode.model.State;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.coffecode.manager.FlightManager;

@Controller
@RequestMapping("/demo")
public class FlightController {

    private GeoCoordinates geoCoordinates = new GeoCoordinates();

    public FlightController() {
        this.geoCoordinates.setLatitude(51.6525013);
        this.geoCoordinates.setLongitude(18.4329261);
    }


    @RequestMapping(value = "/flight", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<?> findNearestFlight() throws MalformedURLException {
        State nearestFlight = new FlightManager(new URL("https://opensky-network.org/api/states/all")).findNearestFlight(geoCoordinates.getLatitude(), geoCoordinates.getLongitude());
        return new ResponseEntity<>(nearestFlight, HttpStatus.OK);
    }

    @RequestMapping(value = "/getdata", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<?> getGeoCoordinates() {
        return new ResponseEntity<>(geoCoordinates, HttpStatus.OK);
    }

    @RequestMapping(value = "/checkflight", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<?> checkFlight(@RequestBody GeoCoordinates geoCoordinates) {
        this.geoCoordinates.setLatitude(geoCoordinates.getLatitude());
        this.geoCoordinates.setLongitude(geoCoordinates.getLongitude());
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }
}