package com.sid.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sid.entity.Alert;
import com.sid.entity.Reading;
import com.sid.entity.Vehicle;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository{
	
	
    @PersistenceContext
    private EntityManager entityManager;
    
	@Override
	public boolean create(Reading reading,Vehicle vehicle) {
		Alert a=new Alert();
		if(reading.getEngineRpm()>vehicle.getRedLineRpm()){
			a.setVin(reading.getVin());
			a.setAlertStatus("HIGH");
			a.setMsg("Engine RPM is high");
			entityManager.persist(a);
		}
		if(reading.getFuelVolume()<(0.1*vehicle.getMaxFuelVolume())){
			a.setVin(reading.getVin());
			a.setAlertStatus("MEDIUM");
			a.setMsg("Fuel Volume is Low");
			entityManager.persist(a);
		}
		if(reading.isEngineCoolantLow()||reading.isCheckEngineLightOn()
				||reading.getTires().getFrontLeft()<32 ||reading.getTires().getFrontLeft()>36
				||reading.getTires().getFrontRight()<32 ||reading.getTires().getFrontRight()>36
				||reading.getTires().getRearLeft()<32 ||reading.getTires().getRearLeft()>36
				||reading.getTires().getRearRight()<32 ||reading.getTires().getRearRight()>36){
			a.setVin(reading.getVin());
			a.setAlertStatus("LOW");
			a.setMsg("Check the tires and Tire pressure");
			entityManager.persist(a);
		}
		entityManager.persist(reading);
		return true;
	}

}
