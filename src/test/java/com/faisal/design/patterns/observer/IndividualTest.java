package com.faisal.design.patterns.observer;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IndividualTest {

	Individual individual;
	Analyst analyst;
	
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
		
		individual = new Individual(analyst);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUpdate() {
		assertFalse(individual.read());
		individual.update(analyst);
		assertTrue(individual.read());
	}

	@Test
	public void testReadBeforeUpdate() {
		assertFalse(individual.read());
	}

	@Test
	public void testReadAfterUpdate() {
		individual.update(analyst);
		assertTrue(individual.read());
	}
	
	@Test
	public void testSetRead() {
		individual.setRead(true);
		assertTrue(individual.read());
	}

}
