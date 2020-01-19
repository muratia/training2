package com.am.training.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Output {

    @JsonProperty("mostSpeeches")
    @JsonPropertyOrder(value = "1")
    private String mostSpeeches;
    @JsonProperty("mostTalkedTopic")
    @JsonPropertyOrder(value = "2")
    private String mostSecurity;

    @JsonProperty("leastWordy")
    @JsonPropertyOrder(value = "3")
    private String leastWordy;

    public Output(String mostSpeeches, String mostSecurity, String leastWordy) {
        this.mostSpeeches = mostSpeeches;
        this.mostSecurity = mostSecurity;
        this.leastWordy = leastWordy;
    }

    public Output() {

    }

    public String getMostSpeeches() {
        return mostSpeeches;
    }

    public void setMostSpeeches(String mostSpeeches) {
        this.mostSpeeches = mostSpeeches;
    }

    public String getMostSecurity() {
        return mostSecurity;
    }

    public void setMostSecurity(String mostSecurity) {
        this.mostSecurity = mostSecurity;
    }

    public String getLeastWordy() {
        return leastWordy;
    }

    public void setLeastWordy(String leastWordy) {
        this.leastWordy = leastWordy;
    }
}
