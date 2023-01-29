package com.api.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="userId",updatable = false,nullable = false)
    private String userId;
    private String email;
    private String password;
    private String username;
    private Integer active=1;
    private boolean isLoacked=false;
    private boolean isExpired=false;
    private boolean isEnabled=true;
    @OneToMany(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "roles")
    private Set<Role> roles;
}
