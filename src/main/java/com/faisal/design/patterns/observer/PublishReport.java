package com.faisal.design.patterns.observer;

import java.util.Date;

public class PublishReport {

	public static void main(String args[]){
		
		// New Analyst to publish Report
		Analyst analyst = new Analyst();
		analyst.setFirstName("Arindham");
		analyst.setLastName("Roy");
		Publication publication = new Publication();
		publication.setName("Outshines the benchmark");
		publication.setPublicationDate(new Date());
		publication.setRating("Buy");
		publication.setSecurity("Star Bucks");
		analyst.setPublication(publication);
		
		
		// Clients subscribed to analyst
		Individual individual = new Individual(analyst);
		Investor investor = new Investor(analyst);
		SalesPerson salesPerson = new SalesPerson(analyst);
		
		
		//Analyst publishes a new Report
		analyst.setChanged();
		analyst.publishes();
		
		System.out.println("Individual read publication: " + individual.read());
		System.out.println("investor read publication: " + investor.read());
		System.out.println("salesPerson read publication: " + salesPerson.read());
		
	}
	
}
