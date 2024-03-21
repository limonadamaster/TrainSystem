package com.example.trainsystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Train(String name, List<TrainStation> trainStations) {
        this.name = name;
        this.route = trainStations;
    }

    @Transient
    private final List<TrainStation> route;

    public Train() {
        this.route = new ArrayList<>();
    }

    public boolean hasRoute(List<TrainStation> routes) {
        return routes.equals(routes);
    }

    public Train(Train train) {
        this.name = train.getName();
        this.route = getRoute();
    }

}
