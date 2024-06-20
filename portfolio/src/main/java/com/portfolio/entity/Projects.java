package com.portfolio.entity;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Projects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "project_name")
	private String projectName;
	
	@Column(name = "client_name")
	private String clientName;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
	private List<RolesAndResponsibilites> rolesAndResponsibilites;

	public Projects(String projectName, String clientName, String location, String role, Date startDate, Date endDate,
			User user, List<RolesAndResponsibilites> rolesAndResponsibilites) {
		super();
		this.projectName = projectName;
		this.clientName = clientName;
		this.location = location;
		this.role = role;
		this.startDate = startDate;
		this.endDate = endDate;
		this.user = user;
		this.rolesAndResponsibilites = rolesAndResponsibilites;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public List<RolesAndResponsibilites> getRolesAndResponsibilites() {
		return rolesAndResponsibilites;
	}

	public void setRolesAndResponsibilites(List<RolesAndResponsibilites> rolesAndResponsibilites) {
		this.rolesAndResponsibilites = rolesAndResponsibilites;
	}
	
	
	
	
}
