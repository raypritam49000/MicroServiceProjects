package com.ray.pritam.studentservice.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String city;
    private String salary;
}
