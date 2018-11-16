package ro.scoalainformala.trips.service;

import ro.scoalainformala.trips.entity.Trip;

import java.util.List;
import java.util.Optional;

public interface TripService {
    Trip createTrip(Trip trip);

    Optional<Trip> getTrip(Integer id);

    Trip editTrip(Trip trip);

    void deleteTrip(Trip trip);

    void deleteTrip(Integer id);

    List<Trip> getAllTrips();

    List<Trip> getAllTripsById(int id);

    void editTrip(Trip trip, int id);
}
