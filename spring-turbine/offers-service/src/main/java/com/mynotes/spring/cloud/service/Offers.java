package com.mynotes.spring.cloud.service;

public class Offers {
	
	private String title;
	
	private String description;
	
	private String detailsLink;
	
	public Offers(String title, String description, String detailsLink) {
		super();
		this.title = title;
		this.description = description;
		this.detailsLink = detailsLink;
	}

	public Offers() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetailsLink() {
		return detailsLink;
	}

	public void setDetailsLink(String detailsLink) {
		this.detailsLink = detailsLink;
	}
	
	

}
