package com.ssis.studentmgmt.config;

import com.ssis.studentmgmt.common.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> registrationBean() {

        FilterRegistrationBean<AuthenticationFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new AuthenticationFilter());
        bean.addUrlPatterns("/student/*","/employee/*","/dashboard/*","/assignment/*","/exam/*");
        return bean;
    }

}
