package com.student.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String id;
    private String name;
    private String email;
    private String city;
    private String mobile;
    private String courseId;
}
