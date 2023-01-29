package com.course.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private String id;
    private String name;
    private String price;
    private String title;
    private String description;
    private String duration;
}
