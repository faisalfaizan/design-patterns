package com.faisal.design.patterns.observer;

import java.beans.IntrospectionException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.faisal.design.patterns.JavaBeanTester;

public class PublicationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBeanProperties() throws IntrospectionException{
	    JavaBeanTester.test(Publication.class);
	}

}
