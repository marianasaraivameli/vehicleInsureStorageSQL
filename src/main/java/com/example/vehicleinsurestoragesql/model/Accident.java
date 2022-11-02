package com.example.vehicleinsurestoragesql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date accidentDate;
    private Double economicLoss;
    private Long idReportedVehicle;

    // um accident direcionado a um unico veiculo
    @ManyToOne
    @JoinColumn(name = "id_accident")
    @JsonIgnoreProperties("accidents")
    private Vehicle vehicle;
}
