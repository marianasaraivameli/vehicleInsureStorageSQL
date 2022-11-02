package com.example.vehicleinsurestoragesql.dto;

import com.example.vehicleinsurestoragesql.model.Vehicle;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDTO implements Serializable {

    private List<VehiclePBMDTO> listVehiclePBMDTO;
    private Double sum;


    public VehicleDTO(List<VehiclePBMDTO> listVehiclePBMDTO, Double sum) {
        this.listVehiclePBMDTO = listVehiclePBMDTO;
        this.sum = sum;
    }
}
