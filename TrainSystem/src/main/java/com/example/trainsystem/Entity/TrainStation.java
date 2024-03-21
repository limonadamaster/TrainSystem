package com.example.trainsystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    private double x_cordinate;
    @JsonIgnore
    private double y_cordinate;

    public TrainStation(String name, double x_cordinate, double y_cordinate) {
        this.name = name;
        this.x_cordinate = x_cordinate;
        this.y_cordinate = y_cordinate;
    }
}
