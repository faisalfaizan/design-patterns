package com.faisal.design.patterns.observer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Individual implements Client, Observer{

	public static final Log log = LogFactory.getLog(Individual.class);
	private Observable observable;
	private boolean isRead;
	
	public Individual(Observable observable){
		this.setObservable(observable);
		observable.addObserver(this);
	}
	
	public void update(Observable observable) {
		Analyst analyst = (Analyst)observable;
		log.info("New publication " + analyst.getPublication().getName() + 
				" by " + analyst.getFirstName() + " " + analyst.getLastName());
		setRead(true);
	}

	public boolean read() {
		return isRead;
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
