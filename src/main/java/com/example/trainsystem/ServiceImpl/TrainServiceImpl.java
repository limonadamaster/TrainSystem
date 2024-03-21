package com.example.trainsystem.ServiceImpl;

import com.example.trainsystem.util.DistanceCalculator;
import com.example.trainsystem.Entity.Train;
import com.example.trainsystem.Entity.TrainStation;
import com.example.trainsystem.util.GlobalGraph;
import com.example.trainsystem.Repository.TrainRepository;
import com.example.trainsystem.Repository.TrainStationRepository;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.trainsystem.util.GlobalGraph.bfsTraversal;

@Service
public class TrainServiceImpl {
    private final TrainRepository trainRepository;
    private final TrainStationRepository trainStationRepository;

    TrainServiceImpl(TrainRepository trainRepository, TrainStationRepository trainStationRepository) {
        this.trainRepository = trainRepository;
        this.trainStationRepository = trainStationRepository;
    }

    public boolean addConnection(String train, List<TrainStation> trainStations) {

        boolean isRouteCreated = false;
        //find the train
        Train foundedTrain = trainRepository.findByName(train);

        if (foundedTrain == null) {
            throw new ExceptionInInitializerError("There is no train with this name!");
        }

        for (TrainStation trainStation : trainStations) {
            TrainStation station = trainStationRepository.findByName(trainStation.getName());

            if (station == null) {
                throw new ExceptionInInitializerError("There is no station with this name: " + trainStation.getName());
            }

            foundedTrain.getRoute().add(station);
        }

        double[] distanceBetweenStations = new double[foundedTrain.getRoute().size()];

        for (int i = 0; i < distanceBetweenStations.length - 1; i++) {
            distanceBetweenStations[i] = DistanceCalculator.calculateDistance(foundedTrain.getRoute().get(i), foundedTrain.getRoute().get(i + 1));
        }
        GlobalGraph.addTrains(foundedTrain);
        GlobalGraph.addRoute(foundedTrain, distanceBetweenStations);

        if (foundedTrain.getRoute().size() > 0) isRouteCreated = true;

        return isRouteCreated;
    }

    public final String findPath(String start, String end) {
        TrainStation startTrainStation = trainStationRepository.findByName(start);
        TrainStation endTrainStation = trainStationRepository.findByName(end);

        GraphPath<TrainStation, DefaultWeightedEdge> shorthestPath = bfsTraversal(
                GlobalGraph.getGraph(),
                startTrainStation,
                endTrainStation);

        System.out.printf(GlobalGraph.findSwitchablePaths(shorthestPath, GlobalGraph.getTrains()));

        return GlobalGraph.findSwitchablePaths(shorthestPath, GlobalGraph.getTrains());
    }

    public final void removeEdge(String train, String station) {
        Train tempTrain = trainRepository.findByName(train);
        TrainStation TempStation = trainStationRepository.findByName(station);

        //find the train
        //find the station
        //remove the station from the list of train
        // boolean isStationRemoved= GlobalGraph.getTrains().remove(TempStation);

        //find the train where they go from this route-edge(graph,train)

        //save the route for the trains
        //remove the edge from the graph
        //add again the edges for the trains
        if (tempTrain != null) {
            for (Train train1 : GlobalGraph.getTrains()) {
                if (train1.getName().equals(tempTrain.getName())) {
                    tempTrain = train1;
                    break;
                }
            }
        }

        GlobalGraph.updateGraphModifyedTrain(tempTrain, TempStation);

    }


}
