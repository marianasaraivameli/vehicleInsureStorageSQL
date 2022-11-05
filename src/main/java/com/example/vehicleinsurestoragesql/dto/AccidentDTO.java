package com.example.vehicleinsurestoragesql.dto;

import com.example.vehicleinsurestoragesql.model.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccidentDTO {
    private Date accidentDate;
    private Double economicLoss;
    @JsonIgnoreProperties("accidents")
    private Vehicle vehicle;

    public AccidentDTO(Date accidentDate, Double economicLoss, Vehicle vehicle) {
        this.accidentDate = accidentDate;
        this.economicLoss = economicLoss;
        this.vehicle = vehicle;
    }
}
