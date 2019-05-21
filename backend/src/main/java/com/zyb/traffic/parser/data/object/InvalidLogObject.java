package com.zyb.traffic.parser.data.object;

public class InvalidLogObject implements ParsedDataObejct {
    private String event;

    public InvalidLogObject(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }
}
