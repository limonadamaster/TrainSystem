package com.example.trainsystem.util;

import com.example.trainsystem.Entity.TrainStation;

public class DistanceCalculator {

    //Calculate distance between to nodes(stations)
    public static double calculateDistance(TrainStation trainStation_start, TrainStation trainStation_end) {
        double deltaX = trainStation_end.getX_cordinate() - trainStation_start.getX_cordinate();
        double deltaY = trainStation_end.getY_cordinate() - trainStation_start.getY_cordinate();

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
