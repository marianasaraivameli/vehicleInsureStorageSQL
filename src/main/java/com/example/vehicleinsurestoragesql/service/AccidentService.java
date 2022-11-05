package com.example.vehicleinsurestoragesql.service;

import com.example.vehicleinsurestoragesql.advisor.InvalidParamException;
import com.example.vehicleinsurestoragesql.dto.AccidentDTO;
import com.example.vehicleinsurestoragesql.model.Accident;
import com.example.vehicleinsurestoragesql.repository.AccidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccidentService implements IAccidentService{

    private final AccidentRepository repository;

    @Override
    public List<AccidentDTO> getAll() {
        List<Accident> accidentList = repository.findAll();

        return accidentList.stream()
                .map(accident -> new AccidentDTO(
                        accident.getAccidentDate(),
                        accident.getEconomicLoss(),
                        accident.getVehicle()))
                .collect(Collectors.toList());
    }

    @Override
    public Accident getById(Long id) {
        if(id == null) {
            throw new InvalidParamException("O id não pode ser nulo");
        }
        return repository.findById(id).orElse(null);
    }

    @Override
    public Accident insert(Accident accident) {
        if(accident == null) {
            throw new InvalidParamException("O acidente não pode ser nulo");
        }
        if(accident.getId() != null) {
            throw new InvalidParamException("O acidente não pode ter ID");
        }
        return repository.save(accident);
    }

    @Override
    public Accident update(Accident accident) {
        if(accident == null) {
            throw new InvalidParamException("O acidente não pode ser nulo");
        }
        if(accident.getId() == null) {
            throw new InvalidParamException("O acidente precisa ter ID");
        }
        return repository.save(accident);
    }

    @Override
    public void deleteById(Long id) {
        if(id == null) {
            throw new InvalidParamException("O id não pode ser nulo");
        }
        repository.deleteById(id);
    }
}
