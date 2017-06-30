package com.sid.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sid.entity.Reading;
import com.sid.entity.Vehicle;
import com.sid.repository.ReadingRepository;
import com.sid.repository.VehicleRepository;

public class ReadingServiceImpl implements ReadingService{

	
    @Autowired
    ReadingRepository repository;
    
    @Autowired
    VehicleService vehicleService;
    
	@Override
	public boolean create(Reading reading) {
		Vehicle vehicle=vehicleService.findOne(reading.getVin());		
		if(vehicle!=null)
			return repository.create(reading,vehicle);
		return false;
	}

}
