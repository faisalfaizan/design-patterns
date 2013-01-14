package com.faisal.design.patterns.observer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Analyst implements Observable {

	Log log = LogFactory.getLog(Analyst.class);
	
	private String firstName;
	private String lastName;
	private int noOfPublications;
	private Publication publication;
	
	
	List<Observer> observers;
	private boolean isChanged = false;

	public Analyst() {
		observers = new ArrayList<Observer>();
	}

	public void addObserver(Observer o) {
		observers.add(o);
	}

	public void deleteObserver(Observer o) {
		observers.remove(o);
	}

	public void notifyObservers() {
		if (isChanged) {
			for (Observer o : observers) {
				o.update(this);
			}
		}
	}

	public void setChanged() {
		this.isChanged = true;
	}
	
	public void publishes(){
		log.info(firstName + " " + lastName + " publishes report");
		notifyObservers();
	}

	/**
	 * @return the fisrtName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the fisrtName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the noOfPublications
	 */
	public int getNoOfPublications() {
		return noOfPublications;
	}

	/**
	 * @param noOfPublications the noOfPublications to set
	 */
	public void setNoOfPublications(int noOfPublications) {
		this.noOfPublications = noOfPublications;
	}

	/**
	 * @return the publication
	 */
	public Publication getPublication() {
		return publication;
	}

	/**
	 * @param publication the publication to set
	 */
	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	/**
	 * @return the observers
	 */
	public List<Observer> getObservers() {
		return observers;
	}

	/**
	 * @param observers the observers to set
	 */
	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}

	/**
	 * @return the isChanged
	 */
	public boolean isChanged() {
		return isChanged;
	}

	/**
	 * @param isChanged the isChanged to set
	 */
	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}

}
