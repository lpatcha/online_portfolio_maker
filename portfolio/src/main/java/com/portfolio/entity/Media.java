package com.portfolio.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "media")
public class Media {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;

@Column(name = "name")
private String name;

public Media() {
	
}

public Media(String name) {
	super();
	this.name = name;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



}
