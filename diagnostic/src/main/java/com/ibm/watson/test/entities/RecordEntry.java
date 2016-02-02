package com.ibm.watson.test.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class RecordEntry {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private Date date;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Medicine> medicines;
	@OneToOne(cascade=CascadeType.ALL)
	private ChildEvaluation childEvaluation;

	public RecordEntry() {
		this.medicines = new ArrayList<Medicine>();
		this.childEvaluation = new ChildEvaluation();
		this.date = new Date();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Medicine> getMedicines() {
		return medicines;
	}
	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	public ChildEvaluation getChildEvaluation() {
		return childEvaluation;
	}
	public void setChildEvaluation(ChildEvaluation childEvaluation) {
		this.childEvaluation = childEvaluation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
