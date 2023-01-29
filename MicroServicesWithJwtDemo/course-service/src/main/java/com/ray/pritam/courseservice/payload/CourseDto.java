package com.ray.pritam.courseservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Long courseId;
    private String courseName;
    private Double coursePrice;
}
