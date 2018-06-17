package com.society.management.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class RoleInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String roleName;
	
	@ElementCollection
	@CollectionTable(name="ROLE_INFO", joinColumns=@JoinColumn(name="id"))
	@Column(name="permitted_url")
	private List<String> permittedURL;
    
	public RoleInfo() {
		super();
	}

	public RoleInfo(int id, String roleName, List<String> permittedURL) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.permittedURL = permittedURL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<String> getPermittedURL() {
		return permittedURL;
	}

	public void setPermittedURL(List<String> permittedURL) {
		this.permittedURL = permittedURL;
	}
	
	@Override
	public String toString() {
		return "RoleInfo [id=" + id + ", roleName=" + roleName + ", permittedURL=" + permittedURL + "]";
	}
	
}
