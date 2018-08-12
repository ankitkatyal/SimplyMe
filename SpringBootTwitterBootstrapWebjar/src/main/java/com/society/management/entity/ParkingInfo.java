package com.society.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parking_info")
public class ParkingInfo {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "parking_id")
	private int parkingId;
	@Column(name = "parking_floor")
	private String parkingFloor;
	@Column(name = "parking_number")
	private int parkingNumber;
	@ManyToOne
    @JoinColumn(name = "flat_id")
    private FlatInfo flatInfo;
	@Column(name = "available")
	private boolean isAvailable;
	
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public ParkingInfo() {
		super();
	}

	public FlatInfo getFlatInfo() {
		return flatInfo;
	}

	public void setFlatInfo(FlatInfo flatInfo) {
		this.flatInfo = flatInfo;
	}

	public int getParkingId() {
		return parkingId;
	}
	
	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}
	public String getParkingFloor() {
		return parkingFloor;
	}
	public void setParkingFloor(String parkingFloor) {
		this.parkingFloor = parkingFloor;
	}
	public int getParkingNumber() {
		return parkingNumber;
	}
	public void setParkingNumber(int parkingNumber) {
		this.parkingNumber = parkingNumber;
	}
	
	

}
