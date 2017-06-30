package com.sid.repository;

import com.sid.entity.Reading;
import com.sid.entity.Vehicle;

public interface ReadingRepository {
	
	boolean create(Reading reading,Vehicle vehicle);

}
