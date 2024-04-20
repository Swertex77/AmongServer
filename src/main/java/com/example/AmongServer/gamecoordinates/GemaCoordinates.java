package com.example.AmongServer.gamecoordinates;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GemaCoordinates {
    private long id;
    private double latitude;
    private double longitude;
    private boolean condition;

    public GemaCoordinates(double latitude, double longitude, boolean condition) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.condition = condition;
    }

}
