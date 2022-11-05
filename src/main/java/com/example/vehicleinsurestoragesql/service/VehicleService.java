package com.example.vehicleinsurestoragesql.service;

import com.example.vehicleinsurestoragesql.advisor.InvalidParamException;
import com.example.vehicleinsurestoragesql.dto.VehicleDTO;
import com.example.vehicleinsurestoragesql.dto.VehiclePBMDTO;
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
        if(id == null) {
            throw new InvalidParamException("O id não pode ser nulo");
        }
        return repository.findById(id).orElse(null);
    }

    @Override
    public Vehicle insert(Vehicle vehicle) {
        if(vehicle == null) {
            throw new InvalidParamException("O vehicle não pode ser nulo");
        }
        if(vehicle.getId() != null) {
            throw new InvalidParamException("O vehicle não pode ter ID");
        }
        return repository.save(vehicle);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        if(vehicle == null) {
            throw new InvalidParamException("O veículo não pode ser nulo");
        }
        if(vehicle.getId() == null) {
            throw new InvalidParamException("O veículo precisa ter ID");
        }
        return repository.save(vehicle);
    }

    @Override
    public void deleteById(Long id) {
        if(id == null) {
            throw new InvalidParamException("O id não pode ser nulo");
        }
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

    @Override
    public List<VehiclePBMDTO> getAllVehicleByEconomicLoss(Double value) {
        return repository.findVehiclesByEconomicLoss(value);
    }

    @Override
    public VehicleDTO getVehiclesByEconomicLossWithSum(Double value) {
        if(value == null) {
            throw new InvalidParamException("O valor não pode ser nulo");
        }
        List<VehiclePBMDTO> listVehicle = repository.findVehiclesByEconomicLoss(value);
        Double sum = repository.findVehiclesByEconomicLossWithSum(value);
        return VehicleDTO.builder()
                .listVehiclePBMDTO(listVehicle)
                .sum(sum)
                .build();
    }

}
