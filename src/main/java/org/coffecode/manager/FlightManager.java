package org.coffecode.manager;

import com.google.gson.Gson;
import org.coffecode.model.Opensky;
import org.coffecode.model.State;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FlightManager {

    private URL url;
    private List<State> states;

    public List<State> getStates() {
        return states;
    }

    public FlightManager(URL url) {
        this.url = url;
        this.states = new ArrayList<State>();
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Opensky opensky = new Gson().fromJson(reader, Opensky.class);

        List<List<String>> openskyStates = opensky.getStates();

        for (List<String> openskyState : openskyStates) {
            State state = new State.StateBuilder()
                    .withIcao24(openskyState.get(0))
                    .withCallsign(openskyState.get(1))
                    .withOrigin_country(openskyState.get(2))
                    .withTime_position(openskyState.get(3))
                    .withLast_contact(openskyState.get(4))
                    .withLongitude(openskyState.get(5))
                    .withLatitude(openskyState.get(6))
                    .withGeo_altitude(openskyState.get(7))
                    .withOn_ground(openskyState.get(8))
                    .withVelocity(openskyState.get(9))
                    .withTrue_track(openskyState.get(10))
                    .withVertical_rate(openskyState.get(11))
                    .withSensors(openskyState.get(12))
                    .withBaro_altitude(openskyState.get(13))
                    .withSquawk(openskyState.get(14))
                    .withSpi(openskyState.get(15))
                    .withPosition_source(openskyState.get(16))
                    .build();
            states.add(state);
        }
    }

    public State findNearestFlight(double latitude, double longitude) {

        long minValue = Math.round(calculateDistance(latitude, longitude, states.get(0).getLatitude(), states.get(0).getLongitude()) / 1000);
        int index = 0;

        for (int i = 1; i < states.size(); i++) {
            long distance = Math.round(calculateDistance(latitude, longitude, states.get(i).getLatitude(), states.get(i).getLongitude()) / 1000);
            if (distance < minValue) {
                minValue = distance;
                index = i;
            }
        }
        System.out.println("Nearest distance: " + minValue);
        return states.get(index);
    }


    private double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2) {

        final int earthRadius = 6371000;
        double φ1 = Math.toRadians(latitude1);
        double φ2 = Math.toRadians(latitude2);
        double Δφ = Math.toRadians(latitude2 - latitude1);
        double Δλ = Math.toRadians(longitude2 - longitude1);

        double a = Math.sin(Δφ / 2) * Math.sin(Δφ / 2)
                + Math.cos(φ1) * Math.cos(φ2) * Math.sin(Δλ / 2) * Math.sin(Δλ / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;
        return distance;
    }

}

