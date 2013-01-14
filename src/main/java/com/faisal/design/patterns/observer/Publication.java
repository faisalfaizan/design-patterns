package com.faisal.design.patterns.observer;

import java.util.Date;

public class Publication {

	private String name;
	private Date publicationDate;
	private String security;
	private String rating;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the publicationDate
	 */
	public Date getPublicationDate() {
		return publicationDate;
	}
	/**
	 * @param publicationDate the publicationDate to set
	 */
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	/**
	 * @return the security
	 */
	public String getSecurity() {
		return security;
	}
	/**
	 * @param security the security to set
	 */
	public void setSecurity(String security) {
		this.security = security;
	}
	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
}
