package com.example.vehicleinsurestoragesql.dto;

import com.example.vehicleinsurestoragesql.model.Accident;
import com.example.vehicleinsurestoragesql.model.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehiclePBMDTO implements Serializable {

    private String plate;
    private String brand;
    private String model;

//    @ManyToOne
//    @JoinColumn(name = "id_accident")
//    @JsonIgnoreProperties("vehicles")
//    private Accident accident;

    public VehiclePBMDTO(Vehicle vehicle) {
        this.plate = vehicle.getPlate();
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
//        this.accident = vehicle.getAccident();
    }
}
