package com.example.vehicleinsurestoragesql.repository;

import com.example.vehicleinsurestoragesql.dto.VehiclePBMDTO;
import com.example.vehicleinsurestoragesql.dto.VehiclePMDTO;
import com.example.vehicleinsurestoragesql.dto.VehicleYDTO;
import com.example.vehicleinsurestoragesql.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("select plate from Vehicle")
    public List<String> findAllPlates();

    public List<VehiclePMDTO> findVehicleByYearOfProductionEquals(Integer year);

    public List<VehicleYDTO> findVehicleByYearOfProductionEqualsAndNumberOfWheelsEquals(Integer year, Integer doors);

    @Query("select v from Vehicle v inner join Accident a on v.id = a.vehicle.id where a.economicLoss >= ?1")
    public List<VehiclePBMDTO> findVehiclesByEconomicLoss(Double value);

    @Query("select sum(economicLoss) from Accident where economicLoss >= ?1")
    public Double findVehiclesByEconomicLossWithSum(Double value);
}