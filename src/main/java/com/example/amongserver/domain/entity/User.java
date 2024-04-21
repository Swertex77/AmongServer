package com.example.amongserver.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "latitude")
    private String name;

    @Column (name = "longitude")
    private boolean isReady;

    @Column (name = "completed")
    private boolean isImposter;            ;

    public User(String name, boolean isReady, boolean isImposter) {
        this.name = name;
        this.isReady = isReady;
        this.isImposter = isImposter;
    }
}
