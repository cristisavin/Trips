package ro.scoalainformala.trips.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.scoalainformala.trips.entity.Trip;
import org.springframework.stereotype.Repository;


@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
}
