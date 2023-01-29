package com.ray.pritam.courseservice.response;

import com.ray.pritam.courseservice.payload.CourseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {
    private String message;
    private List<CourseDto> data = new ArrayList<CourseDto>();
    private Boolean isSuccess;
    private Integer statusCode;
}