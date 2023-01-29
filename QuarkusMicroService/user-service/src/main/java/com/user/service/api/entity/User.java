package com.user.service.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID")
    private String userId;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "EMAIL")

    private String email;
    @Column(name = "ABOUT")
    private String about;
    //other user properties that you want

//    @Transient
//    private List<Rating> ratings=new ArrayList<>();
}
