package com.example.trainsystem;

import com.example.trainsystem.Entity.Train;
import com.example.trainsystem.Entity.TrainStation;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.trainsystem.GlobalGraph.*;

@SpringBootApplication
public class TrainSystemApplication {

    public static void main(String[] args) {
        Train train = new Train();
        Train train2 = new Train();
        Train train1 = new Train();
        train.setName("2121");
        train2.setName("3232");
        train1.setName("4141");

//         //Adding train stations
//        TrainStation stationA = new TrainStation("Montana", 1, 0);
//        TrainStation stationB = new TrainStation("Erden", 2, 1);
//        TrainStation stationC = new TrainStation("Boj4inovci", 3, 4);
//        TrainStation stationD = new TrainStation("Svoge", 1, 4);
//        TrainStation stationE = new TrainStation("Sofiq", 4, 2);
//        TrainStation stationF = new TrainStation("Mezdra", 4, 2);
//        TrainStation stationG = new TrainStation("Varna", 4, 2);
//        train.getRoute().add(stationA);
//        train.getRoute().add(stationC);
//        train.getRoute().add(stationD);
//       train.getRoute().add(stationE);
//        train.getRoute().add(stationA);
////
//        GlobalGraph.getGraph().addVertex(stationA);
//        GlobalGraph.getGraph().addVertex(stationB);
//        GlobalGraph.getGraph().addVertex(stationC);
//        GlobalGraph.getGraph().addVertex(stationD);
//        GlobalGraph.getGraph().addVertex(stationF);
//        GlobalGraph.getGraph().addVertex(stationE);
//        GlobalGraph.getGraph().addVertex(stationG);
////
//        double[] myarr = new double[4];
//        myarr[0] = 1;
//        myarr[1] = 1;
//        myarr[2] = 1;
//        myarr[3] = 1;
////
////
////        // Adding connections
//        GlobalGraph.addRoute(train, myarr);
////
//        train2.getRoute().add(stationC);
//        train2.getRoute().add(stationF);
////       // train2.getRoute().add(stationB);
////        //train2.getRoute().add(stationF);
////       // train2.getRoute().add(stationG);
////
//        double[] myarr2 = new double[4];
//        myarr2[0] = DistanceCalculator.calculateDistance(stationA,stationC);
//        myarr2[1] = DistanceCalculator.calculateDistance(stationC,stationB);
//        myarr2[2] = DistanceCalculator.calculateDistance(stationB,stationF);
//        myarr2[3] = DistanceCalculator.calculateDistance(stationF,stationG);
////
//        GlobalGraph.addRoute(train2, myarr2);
////
////
//        double[] myarr3=new double[2];
//        myarr3[0]=DistanceCalculator.calculateDistance(stationF,stationG);
//        train1.getRoute().add(stationF);
//        train1.getRoute().add(stationG);
//        GlobalGraph.addRoute(train1, myarr3);
//
//        GlobalGraph.addTrains(train);
//        GlobalGraph.addTrains(train2);
//        GlobalGraph.addTrains(train1);
//        GraphPath <TrainStation, DefaultWeightedEdge> shorthestPath =bfsTraversal(GlobalGraph.getGraph(),stationA,stationG);
//       System.out.printf(GlobalGraph.findSwitchablePaths(shorthestPath,GlobalGraph.getTrains()));

        SpringApplication.run(TrainSystemApplication.class, args);
    }


}
