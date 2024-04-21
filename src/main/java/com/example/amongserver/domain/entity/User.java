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

    @Column (name = "login")
    private String login;

    @Column (name = "is_ready")
    private boolean isReady;

    @Column (name = "is_imposter")
    private boolean isImposter;            ;

    public User(String login, boolean isReady, boolean isImposter) {
        this.login = login;
        this.isReady = isReady;
        this.isImposter = isImposter;
    }
}
