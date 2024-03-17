package com.example.trainsystem.DTO;

import com.example.trainsystem.Entity.TrainStation;
import lombok.Data;

import java.util.List;

@Data
public class RouteRequest {
    private String train;
    private List<TrainStation> trainStations;
}
