package com.faisal.design.patterns.observer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Investor implements Client, Observer{

	Log log = LogFactory.getLog(Investor.class);
	
	private String publicationName;
	private String securityName;
	private String rating;
	private boolean isRead;
	public static final String BUY = "Buy";
	
	private Observable observable;
	
	public Investor(){
		
	}
	
	public Investor(Observable observable){
		this.setObservable(observable);
		observable.addObserver(this);
	}
	
	public void update(Observable observable) {
		Analyst analyst = (Analyst)observable;
		publicationName = analyst.getPublication().getName();
		securityName = analyst.getPublication().getSecurity();
		rating = analyst.getPublication().getRating();
		setRead(true);
		
		log.info("New publication " + publicationName + " received from " + 
				analyst.getFirstName() + " " + analyst.getLastName());
		
		if(BUY.equalsIgnoreCase(rating)){
			log.info("Invest in " + securityName);
		}
			
	}

	public boolean read() {
		return isRead;
	}

	/**
	 * @return the publicationName
	 */
	public String getPublicationName() {
		return publicationName;
	}

	/**
	 * @param publicationName the publicationName to set
	 */
	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}

	/**
	 * @return the securityName
	 */
	public String getSecurityName() {
		return securityName;
	}

	/**
	 * @param securityName the securityName to set
	 */
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
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

	/**
	 * @param isRead the isRead to set
	 */
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public Observable getObservable() {
		return observable;
	}

	public void setObservable(Observable observable) {
		this.observable = observable;
	}

}
