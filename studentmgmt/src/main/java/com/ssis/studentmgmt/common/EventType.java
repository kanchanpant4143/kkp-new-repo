package com.ssis.studentmgmt.common;

public enum EventType {

    PTM("PTM"), ANNUAL_FUNCTION("Annual Function"), INDEPENDENCE_DAY("Independence Day"), REPUBLIC_DAY("Republic Day"), GANDHI_JAYANTI("Gandhi Jayanti"), CHRISTMAS("Christmas");
    String value;

    EventType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
