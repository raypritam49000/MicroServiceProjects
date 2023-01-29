package com.rest.student.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="studentId",updatable = false,nullable = false)
    private String id;
    private String name;
    private String city;
    private String gmail;
}
