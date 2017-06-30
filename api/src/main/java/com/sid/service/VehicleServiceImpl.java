package com.sid.service;

import com.sid.entity.Vehicle;
import com.sid.exception.BadRequestException;
import com.sid.exception.ResourceNotFoundException;
import com.sid.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Vehicle findOne(String id) {
        Vehicle existing = repository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with id " + id + " doesn't exist.");
        }
        return existing;
    }

    @Transactional
    public Vehicle create(Vehicle vehicle) {
    	if(findOne(vehicle.getVin())==null)
    		return create(vehicle);
    	else
    		return update(vehicle.getVin(), vehicle);
    }

    @Transactional
    public Vehicle update(String id, Vehicle vehicle) {
        Vehicle existing = repository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with id " + id + " doesn't exist.");
        }
        return repository.update(vehicle);
    }

    @Transactional
    public void delete(String id) {
        Vehicle existing = repository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with id " + id + " doesn't exist.");
        }
        repository.delete(existing);
    }

}