package com.klu.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByObserverId(Long observerId);

    int countByObserverId(Long observerId);
}