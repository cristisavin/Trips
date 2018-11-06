package ro.scoalainformala.trips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.scoalainformala.trips.entity.Trip;
import ro.scoalainformala.trips.service.TripService;

import java.time.LocalDate;

@Controller
public class MyAppController {
    private TripService tripService;

    @Autowired
    public MyAppController(TripService tripService) {
        this.tripService = tripService;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index (Model model) {
//        model.addAttribute("trip", new Trip());
        return "index";
    }

    @RequestMapping(value="/index.html/", method = RequestMethod.GET)
    public String error (Model model) {
        return "index";
    }
}
