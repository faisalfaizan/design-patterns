package com.faisal.design.patterns.observer;

public interface Observable {

	void addObserver(Observer o);
	void deleteObserver(Observer o);
	void notifyObservers();
	void setChanged();
}
