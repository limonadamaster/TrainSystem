package com.example.trainsystem.Repository;

import com.example.trainsystem.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {
    Train findByName(String name);
}
