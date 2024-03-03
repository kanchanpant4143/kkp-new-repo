package com.ssis.studentmgmt.common;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component("enums")
public class EnumList {

    public EnumList() {
    }

    public List<Clazz> getClasses(){
        return Arrays.stream(Clazz.values()).collect(Collectors.toList());
    }

    public List<Designation> getDesignations(){
        return Arrays.stream(Designation.values()).collect(Collectors.toList());
    }

    public List<Gender> getGenders(){
        return Arrays.stream(Gender.values()).collect(Collectors.toList());
    }

    public List<EventType> getEventTypes(){
        return Arrays.stream(EventType.values()).collect(Collectors.toList());
    }

    public List<ExamType> getExams(){
        return Arrays.stream(ExamType.values()).collect(Collectors.toList());
    }

    public List<Role> getRoles(){
        return Arrays.stream(Role.values()).collect(Collectors.toList());
    }

}
