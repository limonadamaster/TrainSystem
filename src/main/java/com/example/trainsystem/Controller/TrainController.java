package com.example.trainsystem.Controller;

import com.example.trainsystem.DTO.RouteRequest;
import com.example.trainsystem.Entity.Train;
import com.example.trainsystem.Entity.TrainStation;
import com.example.trainsystem.ServiceImpl.TrainServiceImpl;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.zip.Deflater;


@Controller
@RestController
@RequestMapping("/v1/train")
public class TrainController {

    private final TrainServiceImpl trainService;

    public TrainController(TrainServiceImpl trainService) {
        this.trainService = trainService;
    }

    @PostMapping("/add")
    public final HttpStatus AddRouteBetweenTwoStations(@RequestBody RouteRequest routeRequest) {

        if (!trainService.addConnection(routeRequest.getTrain(), routeRequest.getTrainStations())) {
            return HttpStatus.NOT_ACCEPTABLE;
        }
        return HttpStatus.CREATED;
    }

    @GetMapping("/find")
    public final String findPath(@RequestParam String station1,
                                 @RequestParam String station2) {
        return trainService.findPath(station1, station2);
    }

    @DeleteMapping("/remove")
    public final void removeConnection(@RequestParam String train,
                                       @RequestParam String station) {
        //find the train
        trainService.removeEdge(train, station);
    }
}
