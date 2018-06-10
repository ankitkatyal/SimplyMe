package com.society.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	@SequenceGenerator(name = "user_sequence", sequenceName = "USER_SEQUENCE")
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "primary_contact")
	private String primaryContact;
	@Column(name = "secondry_contanct")
	private String secondContact;
	@Column(name = "email")
	private String email;
	@Column(name = "birthday")
	private String birthday;
	@Column(name = "aadhar_number")
	private String aadharNumber;
	@Column(name = "password")
	private String password;
	@Column(name = "type")
	private String type;
	@Column(name = "stat_ind")
	private Integer statInd;
	@Column(name = "create_date")
	private Integer createDt;
	@Column(name = "update_date")
	private Integer updateDt;

	public User() {
		super();
	}

	public User(int id, String firstName, String middleName, String lastName, String primaryContact,
			String secondContact, String email, String birthday, String aadharNumber, String password, String type,
			Integer statInd, Integer createDt, Integer updateDt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.primaryContact = primaryContact;
		this.secondContact = secondContact;
		this.email = email;
		this.birthday = birthday;
		this.aadharNumber = aadharNumber;
		this.password = password;
		this.type = type;
		this.statInd = statInd;
		this.createDt = createDt;
		this.updateDt = updateDt;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", primaryContact=" + primaryContact + ", secondContact=" + secondContact + ", email=" + email
				+ ", birthday=" + birthday + ", aadharNumber=" + aadharNumber + ", password=" + password + ", type="
				+ type + ", statInd=" + statInd + ", createDt=" + createDt + ", updateDt=" + updateDt + ", getId()="
				+ getId() + ", getFirstName()=" + getFirstName() + ", getMiddleName()=" + getMiddleName()
				+ ", getLastName()=" + getLastName() + ", getPrimaryContact()=" + getPrimaryContact()
				+ ", getSecondContact()=" + getSecondContact() + ", getEmail()=" + getEmail() + ", getBirthday()="
				+ getBirthday() + ", getAadharNumber()=" + getAadharNumber() + ", getPassword()=" + getPassword()
				+ ", getType()=" + getType() + ", getStatInd()=" + getStatInd() + ", getCreateDt()=" + getCreateDt()
				+ ", getUpdateDt()=" + getUpdateDt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
