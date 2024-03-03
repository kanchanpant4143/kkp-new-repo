package com.ssis.studentmgmt.common;

public enum Gender {

    MALE("M"), FEMALE("F");
    String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
