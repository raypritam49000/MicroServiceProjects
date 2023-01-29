package com.ray.pritam.studentservice.response;

import com.ray.pritam.studentservice.payload.CourseDto;
import com.ray.pritam.studentservice.payload.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCourseStudent {
    private StudentDto studentDtos;
    private List<CourseDto> courseDtos;
}
