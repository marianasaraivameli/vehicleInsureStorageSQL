package com.example.vehicleinsurestoragesql.dto;

import com.example.vehicleinsurestoragesql.model.Vehicle;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleYDTO implements Serializable {

    private String plate;
    private Integer yearOfProduction;
    private Integer numberOfWheels;

    public VehicleYDTO(Vehicle vehicle) {
        this.plate = vehicle.getPlate();
        this.yearOfProduction = vehicle.getYearOfProduction();
        this.numberOfWheels = vehicle.getNumberOfWheels();
    }
}
