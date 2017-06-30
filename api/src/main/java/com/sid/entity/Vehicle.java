package com.sid.entity;

import java.security.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
                      @NamedQuery(name = "Vehicle.findAll",
                                  query = "SELECT vehicle FROM Vehicle vehicle")
              })
@Table(name="Vehicle")
public class Vehicle {
	 
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	String id;
	
	 String vin,make,model;
	 int year,maxFuelVolume,redLineRpm;
	 
	 
	 
	 public Vehicle() {
		 this.id=UUID.randomUUID().toString();
	}
	 
	public int getRedLineRpm() {
		return redLineRpm;
	}
	public void setRedLineRpm(int redLineRpm) {
		this.redLineRpm = redLineRpm;
	}
	Timestamp timeStamp;
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMaxFuelVolume() {
		return maxFuelVolume;
	}
	public void setMaxFuelVolume(int maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "Vehicle [vin=" + vin + ", make=" + make + ", model=" + model + ", year=" + year + ", maxFuelVolume="
				+ maxFuelVolume + ", timeStamp=" + timeStamp + ", getVin()=" + getVin() + ", getMake()=" + getMake()
				+ ", getModel()=" + getModel() + ", getYear()=" + getYear() + ", getMaxFuelVolume()="
				+ getMaxFuelVolume() + ", getTimeStamp()=" + getTimeStamp() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	 
	 

}
