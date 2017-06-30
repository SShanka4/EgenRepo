package com.sid.service;



import java.util.List;

import com.sid.entity.Vehicle;

public interface VehicleService {
	
	List<Vehicle> findAll();
	Vehicle findOne(String id);
	Vehicle create (Vehicle vehicle);
	Vehicle update(String id, Vehicle vehicle);
	void delete(String id);
}