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

}
