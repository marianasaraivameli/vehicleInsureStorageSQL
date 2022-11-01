package com.example.vehicleinsurestoragesql.service;

import com.example.vehicleinsurestoragesql.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    public List<Vehicle> getAll();
    public Vehicle getById(Long id);
    public Vehicle insert(Vehicle vehicle);
    public Vehicle update(Vehicle vehicle);
    public void deleteById(Long id);
}

