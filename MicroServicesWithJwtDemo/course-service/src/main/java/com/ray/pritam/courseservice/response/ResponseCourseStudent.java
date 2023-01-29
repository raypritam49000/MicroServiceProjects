package com.ray.pritam.courseservice.response;

import com.ray.pritam.courseservice.payload.CourseDto;
import com.ray.pritam.courseservice.payload.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseCourseStudent {
    private CourseDto course;
    private List<StudentDto> students;
}
