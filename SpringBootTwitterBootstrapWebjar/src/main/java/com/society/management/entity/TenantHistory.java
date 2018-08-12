package com.society.management.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TenantHistory {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "flat_tenant_history_id")
	private int flatTenantHistoryId;
	@ManyToOne
    @JoinColumn(name = "flat_id")
    private FlatInfo flatInfo;
	@ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo tenantInfo;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "vaccant_date")
	private Date vaccantDate;
	@Column(name = "rent_amount")
	private BigDecimal rentAmount;
	
	
	public int getFlatTenantHistoryId() {
		return flatTenantHistoryId;
	}
	public void setFlatTenantHistoryId(int flatTenantHistoryId) {
		this.flatTenantHistoryId = flatTenantHistoryId;
	}
	public FlatInfo getFlatInfo() {
		return flatInfo;
	}
	public void setFlatInfo(FlatInfo flatInfo) {
		this.flatInfo = flatInfo;
	}
	public UserInfo getTenantInfo() {
		return tenantInfo;
	}
	public void setTenantInfo(UserInfo tenantInfo) {
		this.tenantInfo = tenantInfo;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getVaccantDate() {
		return vaccantDate;
	}
	public void setVaccantDate(Date vaccantDate) {
		this.vaccantDate = vaccantDate;
	}
	public BigDecimal getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(BigDecimal rentAmount) {
		this.rentAmount = rentAmount;
	}

}
