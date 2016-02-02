package com.ibm.watson.test.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.blabs.records.utilities.entity.behavior.Identifiable;
import com.blabs.records.utilities.entity.behavior.Timestampable;

@Entity
public class InfantRecord implements Timestampable, Identifiable<Long> {
	@Id
	@GeneratedValue
	private Long id;
	private Date creation;
	private Date lastUpdate;
	private String grade;
	@OneToOne(cascade=CascadeType.PERSIST)
	private UserProfile userProfile;
	@OneToOne(cascade=CascadeType.ALL)
	private Patient patient;
	@OneToOne(cascade=CascadeType.ALL)
	private FirstAppointment firstAppointment;
	@OneToOne(cascade=CascadeType.ALL)
	private ChildEvaluation childEvaluation;
	@OneToOne(cascade=CascadeType.ALL)
	private ChildFeedback childFeedback;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<RecordEntry> recordEntries;
	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Professional> professionals;
	@ManyToOne(cascade=CascadeType.ALL)
	private Parent father;
	@ManyToOne(cascade=CascadeType.ALL)
	private Parent mother;
	@ManyToOne
	private School school;
	
	public InfantRecord(UserProfile userProfile) {
		this.userProfile = userProfile;
		this.patient = new Patient();
		this.professionals = new ArrayList<Professional>();
		this.father = new Parent();
		this.mother = new Parent();
		this.school = new School();
		this.firstAppointment = new FirstAppointment();
		this.childEvaluation = new ChildEvaluation();
		this.childFeedback = new ChildFeedback();
		this.recordEntries = new HashSet<RecordEntry>();
	}
	
	public InfantRecord() {
		this.patient = new Patient();
		this.professionals = new ArrayList<Professional>();
		this.father = new Parent();
		this.mother = new Parent();
		this.school = new School();
		this.firstAppointment = new FirstAppointment();
		this.childEvaluation = new ChildEvaluation();
		this.childFeedback = new ChildFeedback();
		this.recordEntries = new HashSet<RecordEntry>();
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
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public List<Professional> getProfessionals() {
		return professionals;
	}
	public void setProfessionals(List<Professional> professionals) {
		this.professionals = professionals;
	}
	public Parent getFather() {
		return father;
	}
	public void setFather(Parent father) {
		this.father = father;
	}
	public Parent getMother() {
		return mother;
	}
	public void setMother(Parent mother) {
		this.mother = mother;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public FirstAppointment getFirstAppointment() {
		return firstAppointment;
	}
	public void setFirstAppointment(FirstAppointment firstAppointment) {
		this.firstAppointment = firstAppointment;
	}
	public Set<RecordEntry> getRecordEntries() {
		return recordEntries;
	}
	public void setRecordEntries(Set<RecordEntry> recordEntries) {
		this.recordEntries = recordEntries;
	}
	public ChildEvaluation getChildEvaluation() {
		return childEvaluation;
	}
	public void setChildEvaluation(ChildEvaluation childEvaluation) {
		this.childEvaluation = childEvaluation;
	}
	public ChildFeedback getChildFeedback() {
		return childFeedback;
	}
	public void setChildFeedback(ChildFeedback childFeedback) {
		this.childFeedback = childFeedback;
	}
}