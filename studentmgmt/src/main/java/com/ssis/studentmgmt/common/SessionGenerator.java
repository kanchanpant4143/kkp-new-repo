package com.ssis.studentmgmt.common;

import org.modelmapper.internal.util.Lists;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SessionGenerator {

    /*public static void main(String[] args) {
        System.out.println("session: " + SessionGenerator.generateSessions());
    }*/

    public static String generateSessions() {
        StringBuilder session = new StringBuilder();
        Calendar c = Calendar.getInstance();
        int currentYr = c.get(Calendar.YEAR);
        session.append(currentYr).append("-").append(currentYr + 1);
        return session.toString();
    }

}
