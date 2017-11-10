/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 3
 * Unit Test Classes
 */
package com.andrewasquith.comp2231.assignment3.tests;

/**
 * Import JUnit setup/teardown
 */
import org.junit.After;
import org.junit.Before;

import com.andrewasquith.comp2231.assignment3.question4.ArrayListQueue;

public class ArrayListQueueTests extends QueueTests {
	
	/**
	 * Create a new ArrayList backed queue for testing
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		queue = new ArrayListQueue<Integer>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

}
