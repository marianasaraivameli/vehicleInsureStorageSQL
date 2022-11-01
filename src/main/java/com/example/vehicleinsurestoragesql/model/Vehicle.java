package com.example.vehicleinsurestoragesql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String plate;
    private String brand;
    private String model;
    private Integer yearOfProduction;
    private Integer numberOfWheels;

    // um veiculo - varios sinistros
    @ManyToOne
    @JoinColumn(name = "id_accident")
    @JsonIgnoreProperties("vehicles")
    private Accident accident;
}
