package com.ssis.studentmgmt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AllExceptionHandler {

    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = NullPointerException.class)
    public String exceptionHandleNull(Model m) {
        m.addAttribute("msg","Null pointer exception occured");
        return "nullPage";
    }

    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = NumberFormatException.class)
    public String exceptionHandleNumberFormat(Model m) {
        m.addAttribute("msg","Number format exception occured");
        return "nullPage";
    }

    /*@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public String exceptionHandleGeneric(Model m) {
        m.addAttribute("msg","Generic exception occured");
        return "nullPage";
    }*/

}
