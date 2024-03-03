package com.ssis.studentmgmt.controller;

import com.ssis.studentmgmt.common.Role;
import com.ssis.studentmgmt.dto.UserDto;
import com.ssis.studentmgmt.models.User;
import com.ssis.studentmgmt.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ModelMapper mapper;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String userLogin(Model m) {
        UserDto user = new UserDto();
        m.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public RedirectView authenticate(@ModelAttribute("user") UserDto user, Model m, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("username");
        Optional<User> model = userService.getUserByName(user.getUsername());
        if (model.isPresent()) {
            if (user.getUsername().equals(model.get().getUsername()) && user.getPassword().equals(model.get().getPassword())) {
                user.setRole(model.get().getRole());
                session.setAttribute("user", user);
                return new RedirectView("/dashboard/");
            }
        }
        return new RedirectView("/user/login");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model m, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
        }
        session.invalidate();
        UserDto user = new UserDto();
        m.addAttribute("user", user);
        return "redirect:/user/login";
    }

}
