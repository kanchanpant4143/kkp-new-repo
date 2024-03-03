package com.ssis.studentmgmt.common;

public enum Designation {

    ADMIN("Admin"), TEACHER("Teacher"), PRINCIPAL("Principal"), MANAGEMENT("Management"), OFFICE_STAFF("Office Staff");
    String value;

    Designation(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
