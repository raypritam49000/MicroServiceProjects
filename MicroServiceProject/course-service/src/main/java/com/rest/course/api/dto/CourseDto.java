package com.rest.course.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDto {
    private String courseId;
    private String courseName;
    private String description;
    private BigDecimal fees;
    private String studentId;
}
