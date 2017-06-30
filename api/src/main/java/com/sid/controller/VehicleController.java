package com.sid.controller;

import com.sid.entity.Vehicle;
import com.sid.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {

    @Autowired
    VehicleService service;

    @CrossOrigin(origins="http://mocker.egen.io",maxAge=5000)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        return service.findAll();
    }

    @CrossOrigin(origins="http://mocker.egen.io",maxAge=5000)
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> create(@RequestBody List<Vehicle> vehicleList) {
    	List<Vehicle> returnVehicleList=new ArrayList<Vehicle>();
    	for(Vehicle vehicleIter:vehicleList)
    	{
    		returnVehicleList.add(service.create(vehicleIter));
    	}
    	return returnVehicleList;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}",
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle update(@PathVariable("id") String vin, @RequestBody Vehicle vehicle) {
        return service.update(vin, vehicle);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") String empId) {
        service.delete(empId);
    }
}