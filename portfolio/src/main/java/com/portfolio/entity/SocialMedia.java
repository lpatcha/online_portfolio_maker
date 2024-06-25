package com.portfolio.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "social_media")
public class SocialMedia {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "link")
	private String link;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	
	@ManyToOne()
	@JoinColumn(name = "link_id")
	private Media media;
	
	public SocialMedia() {
	}
	

	public SocialMedia(String link, User user, Media media) {
		super();
		this.link = link;
		this.user = user;
		this.media = media;
	}


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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Media getMedia() {
		return media;
	}


	public void setMedia(Media media) {
		this.media = media;
	}
	
	
	
}
