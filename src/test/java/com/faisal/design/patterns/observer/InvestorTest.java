package com.faisal.design.patterns.observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.beans.IntrospectionException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.faisal.design.patterns.JavaBeanTester;

public class InvestorTest {

	Investor investor;
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
		
		investor = new Investor(analyst);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBeanProperties() throws IntrospectionException{
	    // Do not test the getObservable/setObservable methods
	    JavaBeanTester.test(Investor.class, "observable");
	}
	
	@Test
	public void testUpdate() {
		investor.update(analyst);
		assertTrue(investor.read());
		assertEquals(analyst.getPublication().getName(), investor.getPublicationName());
	}

}
