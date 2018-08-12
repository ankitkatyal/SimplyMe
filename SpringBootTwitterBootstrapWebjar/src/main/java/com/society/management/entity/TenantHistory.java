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
	private Date start_date;
	@Column(name = "vaccant_date")
	private Date vaccant_date;
	@Column(name = "rent_amount")
	private BigDecimal purchase_amount;
	
	
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
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getVaccant_date() {
		return vaccant_date;
	}
	public void setVaccant_date(Date vaccant_date) {
		this.vaccant_date = vaccant_date;
	}
	public BigDecimal getPurchase_amount() {
		return purchase_amount;
	}
	public void setPurchase_amount(BigDecimal purchase_amount) {
		this.purchase_amount = purchase_amount;
	}
	

}
