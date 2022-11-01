package com.example.vehicleinsurestoragesql.service;

import com.example.vehicleinsurestoragesql.model.Accident;
import com.example.vehicleinsurestoragesql.repository.AccidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccidentService implements IAccidentService{

    private final AccidentRepository repository;

    @Override
    public List<Accident> getAll() {
        return repository.findAll();
    }

    @Override
    public Accident getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Accident insert(Accident accident) {
        return repository.save(accident);
    }

    @Override
    public Accident update(Accident accident) {
        return repository.save(accident);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
