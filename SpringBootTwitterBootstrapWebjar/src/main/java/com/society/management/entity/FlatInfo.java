package com.society.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flat_info")
public class FlatInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "flat_id")
	private int flatId;
	@Column(name = "tower")
	private String tower;
	@Column(name = "flat_number")
	private String flatNumber;
	@Column(name= "flat_type")
	private String flatType;
	@Column(name= "flat_area")
	private float flatArea;
	@Column(name= "available")
	private boolean isAvailable;

	
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public int getFlatId() {
		return flatId;
	}
	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}
	public String getTower() {
		return tower;
	}
	public void setTower(String tower) {
		this.tower = tower;
	}
	public String getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}
	public String getFlatType() {
		return flatType;
	}
	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}
	public float getFlatArea() {
		return flatArea;
	}
	public void setFlatArea(float flatArea) {
		this.flatArea = flatArea;
	}

}
