package ro.scoalainformala.trips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.scoalainformala.trips.entity.Trip;
import ro.scoalainformala.trips.service.TripService;

@Controller
public class MyAppController {
    private TripService tripService;
    private Integer id = new Integer(0);

    @Autowired
    public MyAppController(TripService tripService) {
        this.tripService = tripService;
    }

    /**
     * GetMapping for index
     * Return the trip by id (parameter in url). If no trip is selected (no id in URL) the firs in List is selected)
     * If the list of trips is Empty, creates a new trip to display the content of index.html
     * @param trip
     * @param model
     * @param tripId
     * @return redirect to index.html
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewTrip(@ModelAttribute Trip trip, Model model, @RequestParam(value = "id", required = false) Integer tripId) {
        if (tripId != null) {
            model.addAttribute("trips", tripService.getAllTripsById(tripId));
        } else {
            model.addAttribute("trips", tripService.getAllTrips());
            if (tripService.getAllTrips().size() < 1) {
                tripService.createTrip(trip);
                return "redirect:";
            }
        }
        return "index";
    }

    /**
     * Get request for page editTrip.html
     * @param model
     * @param tripId
     * @return page editTrip.html
     */
    @RequestMapping(value = "/editTrip", method = RequestMethod.GET)
    public String returnFormEditTrip(Model model, @RequestParam(value = "idEdit", required = false) Integer tripId) {
        model.addAttribute("trip", tripService.getAllTripsById(tripId).get(0));
        model.addAttribute("idEdit", tripId);
        id = tripId;
        return "editTrip";
    }

    /**
     * Save to Database the info passed into the form. The method editTrip(trip,id) saves the updated trip by creating
     * a new trip and delete the old one.
     * @param trip
     * @param tripId
     * @return redirect to index.html
     */
    @RequestMapping(value = "/editTrip", method = RequestMethod.POST)
    public String editTrip(@ModelAttribute Trip trip, @RequestParam(value = "idEdit", required = false) Integer tripId) {
        tripService.editTrip(trip, id);
        return "redirect:";
    }

    /**
     * Creates a new trip
     * @param model
     * @return index.html
     */
    @RequestMapping(value = "/addTrip", method = RequestMethod.GET)
    public String returnFormTrip(Model model) {
        model.addAttribute("trip", new Trip());
        return "index";
    }

    /**
     * Adds a new trip to database. If the title of the trip already exists, the trip is not created.
     * @param trip
     * @param model
     * @return index.html
     */
    @RequestMapping(value = "/addTrip", method = RequestMethod.POST)
    public String addTrip(@ModelAttribute Trip trip, Model model) {
        for (Trip t : tripService.getAllTrips()) {
            if (t.getTitle().equalsIgnoreCase(trip.getTitle())) {
                return "redirect:";
            }
        }
        tripService.createTrip(trip);
        return "redirect:";
    }

    /**
     * Delete the trip with the id specified in url
     * @param model
     * @param tripId
     * @return index.html
     */
    @RequestMapping(value = "/deleteTrip", method = RequestMethod.GET)
    public String getTripIdToDelete(Model model, @RequestParam(value = "deleteId", required = false) Integer tripId) {
        model.addAttribute(tripService.getAllTrips().get(0));
        tripService.deleteTrip(tripId);
        return "redirect:";
    }

    /**
     *
     * @return the profile page (profile.html)
     */
    @GetMapping(value = "/profile")
    public String profilePage() {
        return "profile";
    }

    /**
     *
     * @return error page (error.html)
     */
    @GetMapping(value = "/error")
    public String errorPage() {
        return "error";
    }

}
