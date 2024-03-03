package com.ssis.studentmgmt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "EXAM_SYLLABUS_TBL")
public class ExamSyllabus extends BaseEntity {
}
