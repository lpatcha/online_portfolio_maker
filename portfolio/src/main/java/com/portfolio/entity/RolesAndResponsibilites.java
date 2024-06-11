package com.portfolio.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "roles_responsibilites")
public class RolesAndResponsibilites {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;

@Column(name = "description")
private String description;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "project_id")
private Projects project;

public RolesAndResponsibilites(String description, Projects project) {
	super();
	this.description = description;
	this.project = project;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Projects getProject() {
	return project;
}

public void setProject(Projects project) {
	this.project = project;
}





}
