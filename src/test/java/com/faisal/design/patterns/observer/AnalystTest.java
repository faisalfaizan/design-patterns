package com.faisal.design.patterns.observer;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnalystTest {

	Analyst analyst;
	Individual individual;
	Investor investor;
	public static final int one = 1;
	
	@Before
	public void setUp() throws Exception {
		analyst = new Analyst();
		analyst.setFirstName("Arindham");
		analyst.setLastName("Roy");
		Publication publication = new Publication();
		publication.setName("Outshines the benchmark");
		publication.setPublicationDate(new Date());
		publication.setRating("Buy");
		publication.setSecurity("Star Bucks");
		analyst.setPublication(publication);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddObserver() {
		individual = new Individual(analyst);
		assertSame(1, analyst.getObservers().size());
		assertEquals(individual, analyst.getObservers().get(0));
	}

	@Test
	public void testDeleteObserver() {
		individual = new Individual(analyst);
		investor = new Investor(analyst);
		
		analyst.deleteObserver(individual);
		
		assertEquals(false, analyst.getObservers().contains(individual));
	}

	@Test
	public void notifyAllObserversWhenChanged() {
		individual = new Individual(analyst);
		investor = new Investor(analyst);
		
		analyst.setChanged();
		analyst.notifyObservers();
		
		assertTrue(individual.read());
		assertTrue(investor.read());
	}
	
	@Test
	public void notifyObserversWhenNothingChanged() {
		individual = new Individual(analyst);
		investor = new Investor(analyst);
		
		analyst.notifyObservers();
		
		assertFalse(individual.read());
		assertFalse(investor.read());
	}

	@Test
	public void testSetChanged() {
		assertFalse(analyst.isChanged());
		analyst.setChanged();
		assertTrue(analyst.isChanged());
	}

	@Test
	public void publishesWhenNoObserversAndNothingChanged() {
		analyst.publishes();
		assertFalse(analyst.isChanged());
		assertSame(0, analyst.getObservers().size());
	}

	@Test
	public void publishesWhenNoObserversAndSomethingChanged() {
		analyst.setChanged();
		analyst.publishes();
		assertTrue(analyst.isChanged());
		assertSame(0, analyst.getObservers().size());
	}
	
	@Test
	public void publishesWithObserversAndNothingChanged() {
		individual = new Individual(analyst);
		investor = new Investor(analyst);
		
		analyst.publishes();
		assertFalse(analyst.isChanged());
		assertFalse(individual.read());
		assertFalse(investor.read());
	}
	
	@Test
	public void publishesWithObserversAndSomethingChanged() {
		individual = new Individual(analyst);
		investor = new Investor(analyst);
		
		analyst.setChanged();
		analyst.publishes();
		assertTrue(analyst.isChanged());
		
		assertTrue(individual.read());
		assertTrue(investor.read());
		
		assertEquals(analyst.getPublication().getName(), investor.getPublicationName());
	}
}
