package com.example.trainsystem.util;

import com.example.trainsystem.Entity.Train;
import com.example.trainsystem.Entity.TrainStation;
import lombok.Data;
import org.apache.logging.log4j.util.PropertySource;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
public class GlobalGraph {
    private static final Graph<TrainStation, DefaultWeightedEdge> graph = new DirectedWeightedMultigraph<>(DefaultWeightedEdge.class);

    private static List<Train> trains = new ArrayList<>();

    private GlobalGraph() {
    }

    public static List<Train> getTrains() {
        return trains;
    }

    public static Graph<TrainStation, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    public static void addTrains(Train train) {
        trains.add(train);
    }

    //Make edge from continue list between [i]->weight[i]->[i+1]
    public static List<DefaultWeightedEdge> addRoute(Train train, double[] weights) {

        List<DefaultWeightedEdge> returnedEdges = new ArrayList<>();

        addVetexToGraph(train);

        for (int i = 0; i < train.getRoute().size(); i++) {

            if (i >= 0 && i + 1 < train.getRoute().size()) {

                TrainStation trainStationStart = train.getRoute().get(i);
                TrainStation trainStationEnd = train.getRoute().get(i + 1);

                DefaultWeightedEdge edge = graph.addEdge(trainStationStart, trainStationEnd);

                graph.setEdgeWeight(edge, weights[i]);
                returnedEdges.add(edge);

            }
        }
        return returnedEdges;
    }

    public static GraphPath<TrainStation, DefaultWeightedEdge> bfsTraversal(Graph<TrainStation, DefaultWeightedEdge> graph,
                                                                            TrainStation start,
                                                                            TrainStation end) {
        if (!graph.containsVertex(start)) {
            throw new IllegalArgumentException("Start vertex is not present in the graph!");
        }
        DijkstraShortestPath<TrainStation, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        GraphPath<TrainStation, DefaultWeightedEdge> shortestPath = dijkstraShortestPath.getPath(start, end);

        return shortestPath;
    }

    public static String findSwitchablePaths(GraphPath<TrainStation, DefaultWeightedEdge> shortestPath, List<Train> trains) {
        List<TrainStation> shortestPathVertexList = shortestPath.getVertexList();
        StringBuilder stations = new StringBuilder();
        if (shortestPathVertexList.size() < 2) {
            return "No alternative paths or passing trains found.";
        }

        for (int i = 1; i < shortestPathVertexList.size() - 1; i++) {
            TrainStation switchStation = shortestPathVertexList.get(i);
            List<Train> trainsAtSwitchStation = new ArrayList<>();
            findPassingThroughTrain(trainsAtSwitchStation, GlobalGraph.getTrains(), switchStation);
            if (trainsAtSwitchStation.size() < 2) {
                continue;
            }

            TrainStation previousStation = shortestPathVertexList.get(i - 1);
            TrainStation nextStation = shortestPathVertexList.get(i + 1);

            stations.append("Switch from train ");
            boolean foundSwitchFromTrain = false;
            for (Train train : trainsAtSwitchStation) {
                if (train.getRoute().contains(previousStation) && train.getRoute().contains(switchStation)) {
                    stations.append(train.getName());
                    foundSwitchFromTrain = true;
                    break;
                }
            }
            if (!foundSwitchFromTrain) {
                // If no switch from train found, skip this station
                continue;
            }

            stations.append(" to train ");
            boolean foundSwitchToTrain = false;
            for (Train train : trainsAtSwitchStation) {
                if (train.getRoute().contains(switchStation) && train.getRoute().contains(nextStation)) {
                    stations.append(train.getName());
                    foundSwitchToTrain = true;
                    break;
                }
            }
            if (!foundSwitchToTrain) {
                // If no switch to train found, skip this station
                continue;
            }

            stations.append(" at station ").append(switchStation.getName()).append("\n");
        }
        return stations.toString();
    }

    public static boolean deleteEdge(TrainStation firstStation, TrainStation secondStation) {
        boolean isEdgeRemoved = false;

        //Find the edge and delete it
        DefaultWeightedEdge removedEdge = graph.removeEdge(firstStation, secondStation);

        //if null ,he doesn't exist
        if (removedEdge != null) {
            isEdgeRemoved = true;
        }

        return isEdgeRemoved;
    }

    private static void findPassingThroughTrain(List<Train> trainsAtSwitchStation, List<Train> trains, TrainStation switchStation) {
        for (Train train : trains) {
            if (train.getRoute().contains(switchStation)) {//if any of train go to my shortest path , take it !
                trainsAtSwitchStation.add(train);
            }
        }
    }

    private static void addVetexToGraph(Train train) {
        for (var vertex : train.getRoute()) {
            graph.addVertex(vertex);
        }

    }

    public static void updateGraphModifyedTrain(
            Train train,
            TrainStation wantToDeletestation) {
        //i need to find the train where they have and station where i want to delete

        List<Train> affectedTrains = new ArrayList<>();

        //find the trains where they go from this station
        for (Train tempTrain : trains) {
            if (tempTrain.getRoute().contains(wantToDeletestation)) {
                affectedTrains.add(tempTrain);
            }
        }

        train.getRoute().remove(wantToDeletestation);

        modifyInTrainList(trains, train);

        updateRoutes(affectedTrains);

    }

    private static int modifyInTrainList(List<Train> trains, Train train) {
        int index = findTrainIndex(trains, train.getName());
        trains.set(index, train);

        if (index != -1 && train != null) {
            return 1;
        }
        return -1;
    }

    private static int findTrainIndex(List<Train> trains, String trainName) {
        for (int i = 0; i < trains.size(); i++) {
            if (trains.get(i).getName().equals(trainName)) {
                return i; // Return the index of the train if found
            }
        }
        return -1; // Return -1 if the train is not found
    }

    private static void updateRoutes(List<Train> trains) {

        List<Train> tempTrains = new ArrayList<>(trains);
        //remove routes of the train
        removeEdges(trains);
        addRoutes(tempTrains);
    }

    private static void removeEdges(List<Train> trains) {
        for (int i = 0; i <= trains.size() - 1; i++) {
            Train train = trains.get(i);

            if (i + 1 >= trains.size()) break;
            TrainStation firstStation = train.getRoute().get(i);
            TrainStation secondStation = train.getRoute().get(i + 1);

            DefaultWeightedEdge edge = graph.getEdge(firstStation, secondStation);

            graph.removeEdge(edge);

        }
    }

    private static void addRoutes(List<Train> tempTrains) {
        for (int i = 0; i < tempTrains.size(); i++) {

            Train train = tempTrains.get(i);

            for (int j = 0; j < train.getRoute().size(); j++) {

                if (j + 1 < train.getRoute().size()) {
                    graph.addEdge(train.getRoute().get(j), train.getRoute().get(j + 1));

                }
            }
        }
    }
}
