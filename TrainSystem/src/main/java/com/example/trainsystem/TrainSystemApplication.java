package com.example.trainsystem;

import com.example.trainsystem.Entity.Train;
import com.example.trainsystem.Entity.TrainStation;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import static com.example.trainsystem.GlobalGraph.*;

@SpringBootApplication(scanBasePackages = "com.example.trainsystem")
public class TrainSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(TrainSystemApplication.class, args);
    }


}
