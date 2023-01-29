package com.rest.student.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDetail {
    private StudentDto studentDto;
    private List<CourseDto> courseList;
}
