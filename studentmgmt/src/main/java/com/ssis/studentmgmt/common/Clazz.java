package com.ssis.studentmgmt.common;

public enum Clazz {

    NURSERY("Nursery"), LKG("LKG"), UKG("UKG"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"),
    SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"), ELEVEN("11"), TWELVE("12");

    String value;

    Clazz(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
