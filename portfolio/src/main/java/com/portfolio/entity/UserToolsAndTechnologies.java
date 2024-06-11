package com.portfolio.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "user_tools_and_technologies")
public class UserToolsAndTechnologies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "proficiency_rating")
	private int proficiencyRating;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne()
	@JoinColumn(name = "tool_id")
	private ToolsAndTechnologies toolsAndTechnologies;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public UserToolsAndTechnologies(int proficiencyRating, String description,
			ToolsAndTechnologies toolsAndTechnologies, User user) {
		super();
		this.proficiencyRating = proficiencyRating;
		this.description = description;
		this.toolsAndTechnologies = toolsAndTechnologies;
		this.user = user;
	}

	public int getProficiencyRating() {
		return proficiencyRating;
	}

	public void setProficiencyRating(int proficiencyRating) {
		this.proficiencyRating = proficiencyRating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ToolsAndTechnologies getToolsAndTechnologies() {
		return toolsAndTechnologies;
	}

	public void setToolsAndTechnologies(ToolsAndTechnologies toolsAndTechnologies) {
		this.toolsAndTechnologies = toolsAndTechnologies;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
