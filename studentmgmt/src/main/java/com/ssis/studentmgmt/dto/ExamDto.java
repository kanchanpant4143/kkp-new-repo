package com.ssis.studentmgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamDto extends BaseDto {

    private String examType;
    private String clazz;
    private String subject;
    private String examDate;
    private String syllabus;

}
