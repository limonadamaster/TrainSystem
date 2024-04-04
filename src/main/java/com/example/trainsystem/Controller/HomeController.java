package com.example.trainsystem.Controller;


import com.example.trainsystem.Entity.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    private static List<People> peoples = new ArrayList<>();

    public HomeController() {
        
    }
@GetMapping("/dynamic")
    public String dynamic(Model model){
        model.addAttribute("peoples",this.peoples);
        model.addAttribute("newPeoples",new People(null,null));
        return "dynamic";
    }
@PostMapping("/new-people")
    public String newPeoples(@ModelAttribute People people){
        this.peoples.add(people);
        return "redirect:/dynamic";
    }
@GetMapping(value = "/")
    public String index() {
        return "index";
    }
}