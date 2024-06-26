package com.portfolio.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class SocialMediaDto {
	
	@Min(value = 1, groups = OnUpdateGroupValidation.class)
	@Max(value = 0, groups = OnCreateGroupValidation.class)
	int id;
	
	@NotBlank
	String link;
	
	@Min(value = 1, message = "userId cannot be null")
    int userId;
	
	@Min(value = 1, message = "MediaId cannot be null")
    int mediaId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMediaId() {
		return mediaId;
	}
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}
   
}
