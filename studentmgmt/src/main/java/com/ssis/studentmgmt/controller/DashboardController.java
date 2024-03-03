package com.ssis.studentmgmt.controller;

import com.ssis.studentmgmt.common.Role;
import com.ssis.studentmgmt.dto.EmployeeDto;
import com.ssis.studentmgmt.dto.UserDto;
import com.ssis.studentmgmt.dto.UserLinkDto;
import com.ssis.studentmgmt.models.Employee;
import com.ssis.studentmgmt.models.UserLink;
import com.ssis.studentmgmt.service.UserLinkService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {

    @Autowired
    UserLinkService userLinkService;
    @Autowired
    ModelMapper mapper;
    private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @GetMapping(value = {"/"})
    public String commonDashboard(Model m, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            String dashboard = "";
            List<UserLink> links = new ArrayList<>();
            UserDto user = (UserDto) session.getAttribute("user");
            if (Role.ADMIN.name().equals(user.getRole())) {
                links = userLinkService.getLinksByRole(Role.ADMIN.name());
                dashboard = "adashboard";
            } else if (Role.TEACHER.name().equals(user.getRole())) {
                links = userLinkService.getLinksByRole(Role.TEACHER.name());
                dashboard = "tdashboard";
            } else if (Role.STUDENT.name().equals(user.getRole())) {
                links = userLinkService.getLinksByRole(Role.STUDENT.name());
                dashboard = "sdashboard";
            }
            List<UserLinkDto> userLinks = modelsToDtoList(links);
            logger.info("links: " + userLinks.toString());
            m.addAttribute("userLinks", userLinks);
            return dashboard;
        }
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String test(Model m) {
        m.addAttribute("testData", "Testing");
        return "index";
    }

    @RequestMapping(value = "/jumbo", method = RequestMethod.GET)
    public String testJumbotron(Model m) {
        //m.addAttribute("testData", "Testing");
        return "jumbotron";
    }

    @RequestMapping(value = "/border", method = RequestMethod.GET)
    public String testBorder(Model m) {
        //m.addAttribute("testData", "Testing");
        return "borderTest";
    }

    public UserLink dtoToModel(UserLinkDto dto) {
        UserLink model = mapper.map(dto, UserLink.class);
        return model;
    }

    public UserLinkDto modeloToDto(UserLink model) {
        UserLinkDto dto = mapper.map(model, UserLinkDto.class);
        return dto;
    }

    private List<UserLinkDto> modelsToDtoList(List<UserLink> models) {
        List<UserLinkDto> employees = models.stream().map(m -> modeloToDto(m)).collect(Collectors.toList());
        return employees;
    }

}
