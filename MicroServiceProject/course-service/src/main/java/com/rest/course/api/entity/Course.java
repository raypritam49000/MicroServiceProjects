package com.rest.course.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Course {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="courseId",updatable = false,nullable = false)
    private String courseId;
    private String courseName;
    private String description;
    @Column(name = "fees",precision = 8, scale = 2)
    private BigDecimal fees;
    private String studentId;
}
