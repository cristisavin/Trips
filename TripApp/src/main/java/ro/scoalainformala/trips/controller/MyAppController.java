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
    public String homepage (Model model) {
        model.addAttribute("trippppp", new Trip());
        Trip trrrrip = new Trip();
        trrrrip.setTitle("Barcelona");
        trrrrip.setDescription("lorem  ipsum");
        trrrrip.setLocation("Barcelona");
        trrrrip.setStartDate(LocalDate.of(2018, 12, 25));
        trrrrip.setEndDate(LocalDate.of(2018,12,28));
        tripService.createTrip(trrrrip);
        return "";
    }
}
