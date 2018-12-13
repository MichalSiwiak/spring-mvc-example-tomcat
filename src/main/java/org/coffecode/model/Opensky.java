package org.coffecode.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Opensky {

    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("states")
    @Expose
    private List<List<String>> states = null;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public List<List<String>> getStates() {
        return states;
    }

    public void setStates(List<List<String>> states) {
        this.states = states;
    }

}
