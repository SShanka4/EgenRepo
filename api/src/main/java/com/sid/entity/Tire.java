package com.sid.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tire")
public class Tire {
	

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	String id;
	
	
		int frontLeft,frontRight,rearLeft,rearRight;
		
		
		public Tire() {
			this.id=UUID.randomUUID().toString();
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int getFrontLeft() {
			return frontLeft;
		}
		public void setFrontLeft(int frontLeft) {
			this.frontLeft = frontLeft;
		}
		public int getFrontRight() {
			return frontRight;
		}
		public void setFrontRight(int frontRight) {
			this.frontRight = frontRight;
		}
		public int getRearLeft() {
			return rearLeft;
		}
		public void setRearLeft(int rearLeft) {
			this.rearLeft = rearLeft;
		}
		public int getRearRight() {
			return rearRight;
		}
		public void setRearRight(int rearRight) {
			this.rearRight = rearRight;
		}
		
		
		

}
