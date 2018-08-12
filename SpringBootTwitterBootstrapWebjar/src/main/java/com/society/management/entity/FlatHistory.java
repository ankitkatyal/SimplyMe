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
	private Date purchase_date;
	@Column(name = "sold_date")
	private Date sold_date;
	@Column(name = "purchase_amount")
	private BigDecimal purchase_amount;
	@Column(name = "sold_amount")
	private BigDecimal sold_amount;
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
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	public Date getSold_date() {
		return sold_date;
	}
	public void setSold_date(Date sold_date) {
		this.sold_date = sold_date;
	}
	public BigDecimal getPurchase_amount() {
		return purchase_amount;
	}
	public void setPurchase_amount(BigDecimal purchase_amount) {
		this.purchase_amount = purchase_amount;
	}
	public BigDecimal getSold_amount() {
		return sold_amount;
	}
	public void setSold_amount(BigDecimal sold_amount) {
		this.sold_amount = sold_amount;
	}

	
}
