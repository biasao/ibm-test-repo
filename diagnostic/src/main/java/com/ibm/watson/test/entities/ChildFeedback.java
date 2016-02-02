package com.ibm.watson.test.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class ChildFeedback {
	@Id
	@GeneratedValue
	private Long id;
	@Column(length=4000)
	private String generalObservation;
	@Column(length=4000)
	private String medicalManagement;
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Medicine> medicines;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGeneralObservation() {
		return generalObservation;
	}
	public void setGeneralObservation(String generalObservation) {
		this.generalObservation = generalObservation;
	}
	public String getMedicalManagement() {
		return medicalManagement;
	}
	public void setMedicalManagement(String medicalManagement) {
		this.medicalManagement = medicalManagement;
	}
	public List<Medicine> getMedicines() {
		return medicines;
	}
	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
}
