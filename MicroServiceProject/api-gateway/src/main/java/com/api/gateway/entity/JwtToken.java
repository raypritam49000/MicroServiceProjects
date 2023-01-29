package com.api.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jwt")
@NoArgsConstructor
@Data
public class JwtToken implements Serializable {
    @Id
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }
}