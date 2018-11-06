package ro.scoalainformala.trips.service;

import ro.scoalainformala.trips.entity.Spot;
import ro.scoalainformala.trips.entity.Trip;

import java.util.List;
import java.util.Optional;

public interface TripService {
    Trip createTripWithSpots(Trip trip, Spot spot1, Spot spot2);
    Trip createTrip(Trip trip);
    Optional<Trip> getTrip(Integer id);
    Trip editTrip(Trip trip);
    void deleteTrip(Trip trip);
    void deleteTrip(Integer id);
    List<Trip> getAllTrips();
}
