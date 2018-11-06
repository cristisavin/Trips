package ro.scoalainformala.trips.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.scoalainformala.trips.entity.Spot;
import ro.scoalainformala.trips.entity.Trip;
import ro.scoalainformala.trips.repository.SpotRepository;
import ro.scoalainformala.trips.repository.TripRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private SpotRepository spotRepository;

    @Override
    public Trip createTripWithSpots(Trip trip, Spot spot1, Spot spot2) {
        spotRepository.save(spot1);
        spotRepository.save(spot2);
        return tripRepository.save(trip);
    }

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
}
