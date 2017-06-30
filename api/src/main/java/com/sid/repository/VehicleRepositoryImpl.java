package com.sid.repository;

import org.springframework.stereotype.Repository;

import com.sid.entity.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll",
                Vehicle.class);
        return query.getResultList();
	}

    public Vehicle findOne(String id) {
		// TODO Auto-generated method stub
		return entityManager.find(Vehicle.class, id);
	}

    public Vehicle create(Vehicle vehicle) {
        entityManager.persist(vehicle);
        return vehicle;
	}
    public Vehicle update(Vehicle vehicle) { 
		return entityManager.merge(vehicle);
	}
    public void delete(Vehicle vehicle) {
        entityManager.remove(vehicle);
		
	}

}
