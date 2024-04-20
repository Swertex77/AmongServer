package com.example.AmongServer.domain;

//import jakarta.persistence.*;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class StartCoordinates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "longitude")
    private double longitude;

    @Column (name = "latitude")
    private double latitude;

    public StartCoordinates(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
