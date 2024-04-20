package com.example.AmongServer.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GemaLiveCoordinates {
    private long id;
    private double latitude;
    private double longitude;
    private boolean condition;
    public GemaLiveCoordinates(double latitude, double longitude, boolean condition) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.condition = condition;
    }

}
