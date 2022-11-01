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
    public List<VehiclePBMDTO> findVehiclesByAccident_EconomicLoss(Double value);
}
