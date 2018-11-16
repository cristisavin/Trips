package ro.scoalainformala.trips.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.scoalainformala.trips.entity.Trip;
import ro.scoalainformala.trips.repository.TripRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;

    @Override
    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public Optional<Trip> getTrip(Integer id) {
        return tripRepository.findById(id);
    }

    @Override
    public Trip editTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    /**
     * Save a new trip and delete the old one(which was edited)
     * @param trip
     * @param id
     */
    @Override
    public void editTrip(Trip trip, int id) {
        tripRepository.save(trip);
        tripRepository.deleteById(id);
    }

    @Override
    public void deleteTrip(Trip trip) {
        tripRepository.delete(trip);
    }

    @Override
    public void deleteTrip(Integer id) {
        tripRepository.deleteById(id);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    /**
     * This method puts at first index of the list the trip selected by user
     * @param id
     * @return the trip list which has at index 0 the trip selected by user
     */
    public List<Trip> getAllTripsById(int id) {
        Optional<Trip> firstTrip = tripRepository.findById(id);
        List<Trip> tripList = new ArrayList<>();
        tripList.add(firstTrip.get());
        for (Trip trip : getAllTrips()) {
            if (trip.getId() != tripList.get(0).getId()) {
                tripList.add(trip);
            }
        }
        return tripList;
    }
}
