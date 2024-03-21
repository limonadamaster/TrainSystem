package com.example.trainsystem.Repository;

import com.example.trainsystem.Entity.TrainStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainStationRepository extends JpaRepository<TrainStation, Long> {
    TrainStation findByName(String name);
}
