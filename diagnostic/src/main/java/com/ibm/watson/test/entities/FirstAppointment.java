package com.ibm.watson.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FirstAppointment {
	@Id
	@GeneratedValue
	private Long id;
	@Column(length=200)
	private String qp;
	@Column(length=4000)
	private String hma;
	@Column(length=6000)
	private String hmp;
	@Column(length=1000)
	private String dnpm;
	@Column(length=2000)
	private String hm;
	@Column(length=2000)
	private String hf;
	@Column(length=2000)
	private String hd;
	@Column(length=2000)
	private String observation;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQp() {
		return qp;
	}
	public void setQp(String qp) {
		this.qp = qp;
	}
	public String getHma() {
		return hma;
	}
	public void setHma(String hma) {
		this.hma = hma;
	}
	public String getHmp() {
		return hmp;
	}
	public void setHmp(String hmp) {
		this.hmp = hmp;
	}
	public String getDnpm() {
		return dnpm;
	}
	public void setDnpm(String dnpm) {
		this.dnpm = dnpm;
	}
	public String getHm() {
		return hm;
	}
	public void setHm(String hm) {
		this.hm = hm;
	}
	public String getHf() {
		return hf;
	}
	public void setHf(String hf) {
		this.hf = hf;
	}
	public String getHd() {
		return hd;
	}
	public void setHd(String hd) {
		this.hd = hd;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	} 
}
