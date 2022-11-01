package com.example.vehicleinsurestoragesql.repository;

import com.example.vehicleinsurestoragesql.model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
}
