package com.portfolio.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "education")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "degree")
	private String degree;

	@Column(name = "description")
	private String description;

	@Column(name = "institution_name")
	private String institutionName;

	@Column(name = "cgpa")
	private double cgpa;

	@Column(name = "max_cgpa")
	private double maxCgpa;

	@Column(name = "start_date", columnDefinition = "DATE")
	private Date startDate;

	@Column(name = "end_date", columnDefinition = "DATE")
	private Date endDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public Education() {
		
	}

	public Education(String degree, String description, String institutionName, int cgpa, int maxCgpa, Date startDate,
			Date endDate, User user) {
		super();
		this.degree = degree;
		this.description = description;
		this.institutionName = institutionName;
		this.cgpa = cgpa;
		this.maxCgpa = maxCgpa;
		this.startDate = startDate;
		this.endDate = endDate;
//		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public double getMaxCgpa() {
		return maxCgpa;
	}

	public void setMaxCgpa(double maxCgpa) {
		this.maxCgpa = maxCgpa;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
