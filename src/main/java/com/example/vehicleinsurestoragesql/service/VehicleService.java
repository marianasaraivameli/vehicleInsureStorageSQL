package com.example.vehicleinsurestoragesql.service;

import com.example.vehicleinsurestoragesql.dto.VehiclePMDTO;
import com.example.vehicleinsurestoragesql.dto.VehicleYDTO;
import com.example.vehicleinsurestoragesql.model.Vehicle;
import com.example.vehicleinsurestoragesql.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService implements IVehicleService {

    private final VehicleRepository repository;

    @Override
    public List<Vehicle> getAll() {
        return repository.findAll();
    }

    @Override
    public Vehicle getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Vehicle insert(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<String> getAllPlate() {
        return repository.findAllPlates();
    }

    @Override
    public List<VehiclePMDTO> getAllVehicleByYear(Integer year) {
        return repository.findVehicleByYearOfProductionEquals(year);
    }

    @Override
    public List<VehicleYDTO> getAllVehicleByYearAndDoors(Integer year, Integer doors) {
        return repository.findVehicleByYearOfProductionEqualsAndNumberOfWheelsEquals(year, doors);
    }

}
