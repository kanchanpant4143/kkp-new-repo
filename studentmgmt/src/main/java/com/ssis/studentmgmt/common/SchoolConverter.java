package com.ssis.studentmgmt.common;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SchoolConverter implements Converter {

    DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

    @Override
    public Date convert(MappingContext context) {
        if (context.getSource() == null) {
            return null;
        }
        try {
            Date date = dateFormat.parse((String) context.getSource());
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*Converter<String, String> toUpperCase = new Converter<String, String>() {*/
    /*};*/

}
