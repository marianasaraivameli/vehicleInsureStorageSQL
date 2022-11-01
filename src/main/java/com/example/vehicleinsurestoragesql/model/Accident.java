package com.example.vehicleinsurestoragesql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date accidentDate;
    private String economicLoss;
    private Long idReportedVehicle;

    @OneToMany(mappedBy = "accident", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("accident")
    private List<Vehicle> vehicles;
}
