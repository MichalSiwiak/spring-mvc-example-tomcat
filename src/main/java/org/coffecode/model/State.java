package org.coffecode.model;

public class State {

    private String icao24;
    private String callsign;
    private String origin_country;
    private int time_position;
    private int last_contact;
    private double longitude;
    private double latitude;
    private double geo_altitude;
    private boolean on_ground;
    private double velocity;
    private double true_track;
    private double vertical_rate;
    private String sensors;
    private double baro_altitude;
    private String squawk;
    private boolean spi;
    private int position_source;

    public String getIcao24() {
        return icao24;
    }

    public String getCallsign() {
        return callsign;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    public int getTime_position() {
        return time_position;
    }

    public int getLast_contact() {
        return last_contact;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getGeo_altitude() {
        return geo_altitude;
    }

    public boolean isOn_ground() {
        return on_ground;
    }

    public double getVelocity() {
        return velocity;
    }

    public double getTrue_track() {
        return true_track;
    }

    public double getVertical_rate() {
        return vertical_rate;
    }

    public String getSensors() {
        return sensors;
    }

    public double getBaro_altitude() {
        return baro_altitude;
    }

    public String getSquawk() {
        return squawk;
    }

    public boolean isSpi() {
        return spi;
    }

    public int getPosition_source() {
        return position_source;
    }

    public State(final StateBuilder builder) {
        this.icao24 = builder.icao24;
        this.callsign = builder.callsign;
        this.origin_country = builder.origin_country;
        this.time_position = builder.time_position;
        this.last_contact = builder.last_contact;
        this.longitude = builder.longitude;
        this.latitude = builder.latitude;
        this.geo_altitude = builder.geo_altitude;
        this.on_ground = builder.on_ground;
        this.velocity = builder.velocity;
        this.true_track = builder.true_track;
        this.vertical_rate = builder.vertical_rate;
        this.sensors = builder.sensors;
        this.baro_altitude = builder.baro_altitude;
        this.squawk = builder.squawk;
        this.spi = builder.spi;
        this.position_source = builder.position_source;
    }

    @Override
    public String toString() {
        return "State{" +
                "icao24='" + icao24 + '\'' +
                ", callsign='" + callsign + '\'' +
                ", origin_country='" + origin_country + '\'' +
                ", time_position='" + time_position + '\'' +
                ", last_contact='" + last_contact + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", geo_altitude='" + geo_altitude + '\'' +
                ", on_ground='" + on_ground + '\'' +
                ", velocity='" + velocity + '\'' +
                ", true_track='" + true_track + '\'' +
                ", vertical_rate='" + vertical_rate + '\'' +
                ", sensors='" + sensors + '\'' +
                ", baro_altitude='" + baro_altitude + '\'' +
                ", squawk='" + squawk + '\'' +
                ", spi='" + spi + '\'' +
                ", position_source='" + position_source + '\'' +
                '}';
    }

    public static final class StateBuilder {
        private String icao24;
        private String callsign;
        private String origin_country;
        private int time_position;
        private int last_contact;
        private double longitude;
        private double latitude;
        private double geo_altitude;
        private boolean on_ground;
        private double velocity;
        private double true_track;
        private double vertical_rate;
        private String sensors;
        private double baro_altitude;
        private String squawk;
        private boolean spi;
        private int position_source;

        public StateBuilder withIcao24(String icao24) {
            this.icao24 = icao24;
            return this;
        }

        public StateBuilder withCallsign(String callsign) {
            this.callsign = callsign;
            return this;
        }

        public StateBuilder withOrigin_country(String origin_country) {
            this.origin_country = origin_country;
            return this;
        }

        public StateBuilder withTime_position(String time_position) {
            try {
                this.time_position = Integer.parseInt(time_position);
            } catch (NumberFormatException e) {
                this.time_position = 0;
            } finally {
                return this;
            }
        }

        public StateBuilder withLast_contact(String last_contact) {
            try {
                this.last_contact = Integer.parseInt(last_contact);
            } catch (NumberFormatException e) {
                this.last_contact = 0;
            } finally {
                return this;
            }
        }

        public StateBuilder withLongitude(String longitude) {
            try {
                this.longitude = Double.parseDouble(longitude);
            } catch (NumberFormatException e) {
                this.longitude = 0;
            } finally {
                return this;
            }
        }

        public StateBuilder withLatitude(String latitude) {
            try {
                this.latitude = Double.parseDouble(latitude);
            } catch (NumberFormatException e) {
                this.latitude = 0;
            } finally {
                return this;
            }
        }

        public StateBuilder withGeo_altitude(String geo_altitude) {
            try {
                this.geo_altitude = Double.parseDouble(geo_altitude);
            } catch (NumberFormatException e) {
                this.geo_altitude = 0;
            } finally {
                return this;
            }
        }

        public StateBuilder withOn_ground(String on_ground) {
            try {
                this.on_ground = Boolean.valueOf(on_ground);
            } catch (Exception e) {
                this.on_ground = false;
            } finally {
                return this;
            }
        }

        public StateBuilder withVelocity(String velocity) {
            try {
                this.velocity = Double.parseDouble(velocity);
            } catch (NumberFormatException e) {
                this.velocity = 0;
            } finally {
                return this;
            }
        }

        public StateBuilder withTrue_track(String true_track) {
            try {
                this.true_track = Double.parseDouble(true_track);
            } catch (NumberFormatException e) {
                this.true_track = 0;
            } finally {
                return this;
            }
        }

        public StateBuilder withVertical_rate(String vertical_rate) {
            try {
                this.vertical_rate = Double.parseDouble(vertical_rate);
            } catch (NumberFormatException e) {
                this.vertical_rate = 0;
            } finally {
                return this;
            }
        }

        public StateBuilder withSensors(String sensors) {
            this.sensors = sensors;
            return this;
        }

        public StateBuilder withBaro_altitude(String baro_altitude) {
            try {
                this.baro_altitude = Double.parseDouble(baro_altitude);
            } catch (NumberFormatException e) {
                this.baro_altitude = 0;
            } finally {
                return this;
            }
        }

        public StateBuilder withSquawk(String squawk) {
            this.squawk = squawk;
            return this;
        }

        public StateBuilder withSpi(String spi) {
            try {
                this.spi = Boolean.valueOf(spi);
            } catch (Exception e) {
                this.spi = false;
            } finally {
                return this;
            }
        }

        public StateBuilder withPosition_source(String position_source) {
            try {
                this.position_source = Integer.parseInt(position_source);
            } catch (NumberFormatException e) {
                this.position_source = 0;
            } finally {
                return this;
            }
        }

        public State build() {
            return new State(this);
        }
    }
}
