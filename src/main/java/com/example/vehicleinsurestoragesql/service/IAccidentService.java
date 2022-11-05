package com.example.vehicleinsurestoragesql.service;

import com.example.vehicleinsurestoragesql.dto.AccidentDTO;
import com.example.vehicleinsurestoragesql.model.Accident;

import java.util.List;

public interface IAccidentService {
    public List<AccidentDTO> getAll();
    public Accident getById(Long id);
    public Accident insert(Accident accident);
    public Accident update(Accident accident);
    public void deleteById(Long id);
}
