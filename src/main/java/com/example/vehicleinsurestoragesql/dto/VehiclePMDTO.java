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
public class VehiclePMDTO implements Serializable {

    private String plate;
    private String brand;

    public VehiclePMDTO(Vehicle vehicle) {
        this.plate = vehicle.getPlate();
        this.brand = vehicle.getBrand();
    }
}
