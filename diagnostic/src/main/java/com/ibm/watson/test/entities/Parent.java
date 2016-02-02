package com.ibm.watson.test.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.blabs.records.utilities.entity.behavior.impl.AbstractSimpleCRUDEntity;

@Entity
public class Parent extends AbstractSimpleCRUDEntity<Long> {
	@Id
	@GeneratedValue
	private Long id;
	private Date creation;
	private Date lastUpdate;
	private Date birthday;
	private String address;
	private String name;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Phone> phones;
	@Transient
	private Phone phoneOnRecord;

	public Parent() {
		this.phones = new ArrayList<Phone>();
		this.phoneOnRecord = new Phone();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreation() {
		return creation;
	}
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	public Phone getPhoneOnRecord() {
		return phoneOnRecord;
	}
	public void setPhoneOnRecord(Phone phoneOnRecord) {
		if(phoneOnRecord != null && phones.contains(phoneOnRecord)) {
			this.phones.add(phoneOnRecord);
		}
		this.phoneOnRecord = phoneOnRecord;
	}
}