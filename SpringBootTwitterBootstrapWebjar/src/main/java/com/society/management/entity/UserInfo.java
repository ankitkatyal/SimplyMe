package com.society.management.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name="user_info")
public class UserInfo extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	
	
	@Column(name = "first_name")
	@NotEmpty(message = "Please provide your first name")
	private String firstName;
	
	@Column(name = "last_name")
	@NotEmpty(message = "Please provide your last name")
	private String lastName;
	
	
	@Column(name = "middle_name")
	private String middleName;
	
	
	@Column(name = "primary_contact")
	private String primaryContact;
	
	
	@Column(name = "secondry_contanct")
	private String secondContact;
	
	
	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")
	private String email;
	
	
	@Column(name = "confirmation_token")
	private String confirmationToken;

	@Column(name = "token_expiry_date")
	private Date tokenExpiryDate;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "aadhar_number")
	private String aadharNumber;

	@Column(name = "password")
	@Transient
	private String password;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "stat_ind")
	private Integer statInd;
	
	@Column(name = "create_date")
	private Date createDt;
	
	@Column(name = "update_date")
	private Date updateDt;
	

	

	@Column(name = "enabled")
	private boolean enabled;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<RoleInfo> roleInfo;

	public UserInfo() {
		super();
	}

	public UserInfo(int id, String firstName, String middleName, String lastName, String primaryContact,
			String secondContact, String email, String birthday, String aadharNumber, String password, String type,
			Integer statInd, Date createDt, Date updateDt, Set<RoleInfo> roleInfo) {
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
		this.roleInfo = roleInfo;
	}

	@PrePersist
	  protected void onCreate() {
		createDt = new Date();
	  }

	  @PreUpdate
	  protected void onUpdate() {
	    updateDt = new Date();
	  }
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
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

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public void setRoleInfo(Set<RoleInfo> roleInfo) {
		this.roleInfo = roleInfo;
	}

	public Set<RoleInfo> getRoleInfo() {
		return roleInfo;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
	public Date getTokenExpiryDate() {
		return tokenExpiryDate;
	}

	public void setTokenExpiryDate(Date tokenExpiryDate) {
		this.tokenExpiryDate = tokenExpiryDate;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", primaryContact=" + primaryContact + ", secondContact=" + secondContact + ", email="
				+ email + ", birthday=" + birthday + ", aadharNumber=" + aadharNumber + ", password=" + password
				+ ", type=" + type + ", statInd=" + statInd + ", createDt=" + createDt + ", updateDt=" + updateDt
				+ ", roleInfo=" + roleInfo + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getMiddleName()=" + getMiddleName() + ", getLastName()=" + getLastName() + ", getPrimaryContact()="
				+ getPrimaryContact() + ", getSecondContact()=" + getSecondContact() + ", getEmail()=" + getEmail()
				+ ", getBirthday()=" + getBirthday() + ", getAadharNumber()=" + getAadharNumber() + ", getPassword()="
				+ getPassword() + ", getType()=" + getType() + ", getStatInd()=" + getStatInd() + ", getCreateDt()="
				+ getCreateDt() + ", getUpdateDt()=" + getUpdateDt() + ", getRoleInfo()=" + getRoleInfo()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
