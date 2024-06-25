package com.portfolio.entity;
import java.util.List;
import jakarta.persistence.*;


@Entity
@Table(name = "categories")
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "category_name")
	private String categoryName;
	

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<ToolsAndTechnologies> toolsAndTechnologies;
	
	public Categories() {
		
	}


	public Categories(String categoryName, List<ToolsAndTechnologies> toolsAndTechnologies) {
		super();
		this.categoryName = categoryName;
		this.toolsAndTechnologies = toolsAndTechnologies;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public List<ToolsAndTechnologies> getToolsAndTechnologies() {
		return toolsAndTechnologies;
	}


	public void setToolsAndTechnologies(List<ToolsAndTechnologies> toolsAndTechnologies) {
		this.toolsAndTechnologies = toolsAndTechnologies;
	}


	@Override
	public String toString() {
		return "Categories [id=" + id + ", categoryName=" + categoryName +  "]";
	}
	

	
	
	
	
}
