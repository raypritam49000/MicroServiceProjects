package com.student.service.api.dto;

import com.course.service.dto.CourseDTO;
import com.student.service.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseDTO {
    private StudentDTO studentDTO;
    private CourseDTO courseDTO;
}
