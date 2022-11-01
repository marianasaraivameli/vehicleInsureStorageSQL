package com.example.vehicleinsurestoragesql.repository;

import com.example.vehicleinsurestoragesql.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("select plate from Vehicle")
    public List<String> findAllPlates();
}
