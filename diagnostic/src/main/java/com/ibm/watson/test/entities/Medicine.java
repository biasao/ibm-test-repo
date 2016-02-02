package com.ibm.watson.test.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.blabs.records.utilities.entity.behavior.impl.AbstractSimpleCRUDEntity;

@Entity
public class Medicine extends AbstractSimpleCRUDEntity<Long> {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private String concentration;
	@Column
	private String dosage;
	@Column
	private String collateralEffect;
	@Column
	private Date creation;
	@Column
	private Date lastUpdate;

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
	public String getConcentration() {
		return concentration;
	}
	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getCollateralEffect() {
		return collateralEffect;
	}
	public void setCollateralEffect(String collateralEffect) {
		this.collateralEffect = collateralEffect;
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
}
