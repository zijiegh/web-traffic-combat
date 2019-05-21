package com.zyb.traffic.avros;


public enum ConversionType {
    TARGET_PAGE("TargetPage"),
    EVENT("Event");

    private String value;

    ConversionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
