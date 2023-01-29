package com.rest.student.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String id;
    private String name;
    private String city;
    private String gmail;
}
