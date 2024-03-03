package com.ssis.studentmgmt.common;

import com.ssis.studentmgmt.controller.EmployeeController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component("sessionUtilityBean")
public class SessionUtilityBean {

    private static final Logger logger = LoggerFactory.getLogger(SessionUtilityBean.class);

    public void removeMessageFromSession() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            session.removeAttribute("message");
        } catch (Exception ex) {
            logger.error("No Request: ", ex);
        }
    }

}
