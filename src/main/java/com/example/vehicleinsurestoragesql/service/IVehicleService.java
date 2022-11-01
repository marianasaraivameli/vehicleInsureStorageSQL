package com.example.vehicleinsurestoragesql.service;

import com.example.vehicleinsurestoragesql.dto.VehiclePMDTO;
import com.example.vehicleinsurestoragesql.dto.VehicleYDTO;
import com.example.vehicleinsurestoragesql.model.Vehicle;

import java.util.List;

public interface IVehicleService {
    public List<Vehicle> getAll();
    public Vehicle getById(Long id);
    public Vehicle insert(Vehicle vehicle);
    public Vehicle update(Vehicle vehicle);
    public void deleteById(Long id);
    public List<String> getAllPlate();
    public List<VehiclePMDTO> getAllVehicleByYear(Integer year);
    public List<VehicleYDTO> getAllVehicleByYearAndDoors(Integer year, Integer doors);
}

