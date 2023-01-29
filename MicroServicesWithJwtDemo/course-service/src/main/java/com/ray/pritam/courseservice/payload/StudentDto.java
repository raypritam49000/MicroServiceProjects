package com.ray.pritam.courseservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

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
