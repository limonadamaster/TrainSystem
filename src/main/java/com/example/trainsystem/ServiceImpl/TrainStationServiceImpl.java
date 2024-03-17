package com.example.trainsystem.ServiceImpl;

import com.example.trainsystem.Repository.TrainRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainStationServiceImpl {

    private final TrainRepository trainRepository;


    public TrainStationServiceImpl(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }


}
