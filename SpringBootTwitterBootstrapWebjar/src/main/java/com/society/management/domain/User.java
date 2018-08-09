package com.society.management.domain;

import javax.validation.constraints.NotNull;

public class User {

	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String primaryContact;
	private String secondContact;
	@NotNull
	private String email;
	private String birthday;
	private String aadharNumber;
	private String password;
	private String matchingPassword;
	private String type;
	private Integer statInd;
	private Integer createDt;
	private Integer updateDt;
	private boolean enabled;
	private String confirmationToken;
	
	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}

	public String getSecondContact() {
		return secondContact;
	}

	public void setSecondContact(String secondContact) {
		this.secondContact = secondContact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStatInd() {
		return statInd;
	}

	public void setStatInd(Integer statInd) {
		this.statInd = statInd;
	}

	public Integer getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Integer createDt) {
		this.createDt = createDt;
	}

	public Integer getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Integer updateDt) {
		this.updateDt = updateDt;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}
}
