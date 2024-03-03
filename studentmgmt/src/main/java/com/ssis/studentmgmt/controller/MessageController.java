package com.ssis.studentmgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/message"})
public class MessageController {

    @GetMapping(value = {"/principal/add"})
    public String addPrincipalMsg(Model m) {
        //m.addAttribute("testData", "Testing");
        return "principalMsg";
    }

    @GetMapping(value = {"/teacher/add"})
    public String addTeacherMsg(Model m) {
        //m.addAttribute("testData", "Testing");
        return "teacherMsg";
    }

}
