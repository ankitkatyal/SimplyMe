package com.society.management.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class FlatHistory {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "flat_history_id")
	private int flatHistoryId;
	@ManyToOne
    @JoinColumn(name = "flat_id")
    private FlatInfo flatInfo;
	@ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo ownerInfo;
	@Column(name = "purchase_date")
	private Date purchaseDate;
	@Column(name = "sold_date")
	private Date soldDate;
	@Column(name = "purchase_amount")
	private BigDecimal purchaseAmount;
	@Column(name = "sold_amount")
	private BigDecimal soldAmount;
	
	
	public int getFlatHistoryId() {
		return flatHistoryId;
	}
	public void setFlatHistoryId(int flatHistoryId) {
		this.flatHistoryId = flatHistoryId;
	}
	public FlatInfo getFlatInfo() {
		return flatInfo;
	}
	public void setFlatInfo(FlatInfo flatInfo) {
		this.flatInfo = flatInfo;
	}
	public UserInfo getOwnerInfo() {
		return ownerInfo;
	}
	public void setOwnerInfo(UserInfo ownerInfo) {
		this.ownerInfo = ownerInfo;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Date getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}
	public BigDecimal getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(BigDecimal purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public BigDecimal getSoldAmount() {
		return soldAmount;
	}
	public void setSoldAmount(BigDecimal soldAmount) {
		this.soldAmount = soldAmount;
	}
	
	

	
}
