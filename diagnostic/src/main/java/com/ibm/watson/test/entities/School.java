package com.ibm.watson.test.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.blabs.records.utilities.entity.behavior.impl.AbstractSimpleCRUDEntity;

@Entity
public class School extends AbstractSimpleCRUDEntity<Long>{
	@Id
	@GeneratedValue
	protected Long id;
	private String name;
	private String address;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Phone> phones;
	private Date creation;
	private Date lastUpdate;

	public School() {
		phones = new ArrayList<Phone>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getConcatenatedPhones() {
		StringBuilder concatenatedPhones = new StringBuilder();
		
		for (int i = 0; i < this.getPhones().size(); i++) {
			Phone phone = getPhones().get(i);
			
			if(i == this.getPhones().size() - 1) {
				concatenatedPhones.append(phone.getNumber());
				break;
			}
			concatenatedPhones.append(phone.getNumber()).append(", ");
		}
		
		return concatenatedPhones.toString();
	}
}