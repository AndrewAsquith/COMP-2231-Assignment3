/**
 * 
 */
package com.andrewasquith.comp2231.assignment3.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList;

/**
 * @author Andrew
 *
 */
public class UnorderedArrayListTests {

	UnorderedArrayList<Integer> list;

	/**
	 * Create a new list with a capacity of 10
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new UnorderedArrayList<Integer>(10);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test that the list is created empty
	 */
	@Test
	public final void testListIsCreatedEmpty() {
		assertTrue(list.isEmpty());
	}

	/**
	 * Test that empty is size 0
	 */
	@Test
	public final void testListIsCreatedWithSizeZero() {
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}
	
	/**
	 * Test that size returns correct value after adding to front
	 */
	@Test
	public final void testSizeIsCorrectAfterAddingToFront() {
		list.addToFront(3);
		list.addToFront(4);
		assertEquals(2, list.size());
	}
	
	/**
	 * Test that size returns the correct value after adding to rear
	 */
	@Test
	public final void testSizeIsCorrectAfterAddingToRear() {
		list.addToRear(5);
		list.addToRear(6);
		list.addToRear(7);
		assertEquals(3, list.size());
	}
	
	/**
	 * Test that size returns correct value after adding to both front and rear
	 */
	@Test
	public final void testSizeIsCorrectAfterAddingToFrontAndRear() {
		list.addToFront(2);
		list.addToRear(6);
		list.addToFront(3);
		list.addToFront(7);
		assertEquals(4, list.size());
	}
	
	/**
	 * Test that the list will expand after 10 elements added to front
	 */
	@Test
	public final void testListWillHoldMoreThanInitialCapacityWhenAddingToFront() {
		list.addToFront(1);
		list.addToFront(2);
		list.addToFront(3);
		list.addToFront(4);
		list.addToFront(5);
		list.addToFront(6);
		list.addToFront(7);
		list.addToFront(8);
		list.addToFront(9);
		list.addToFront(10);
		list.addToFront(11);
		list.addToFront(12);
		assertEquals(12, list.size());
	}
	
	/**
	 * Test that the list will expand after 10 elements added to rear
	 */
	@Test
	public final void testListWillHoldMoreThanInitialCapacityWhenAddingToRear() {
		list.addToRear(1);
		list.addToRear(2);
		list.addToRear(3);
		list.addToRear(4);
		list.addToRear(5);
		list.addToRear(6);
		list.addToRear(7);
		list.addToRear(8);
		list.addToRear(9);
		list.addToRear(10);
		list.addToRear(11);
		list.addToRear(12);
		assertEquals(12, list.size());
	}

	/**
	 * Test method for
	 * {@link com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList#first()}
	 * when there is a single element.
	 */
	@Test
	public final void testFirstWithSingleElement() {
		Integer expected = new Integer(7);
		list.addToFront(expected);
		assertEquals(expected, list.first());
	}

	/**
	 * Test method for
	 * {@link com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList#last()}
	 * when there is a single element.
	 */
	@Test
	public final void testLastWithSingleElement() {
		Integer expected = new Integer(7);
		list.addToFront(expected);
		assertEquals(expected, list.last());
	}

	/**
	 * Test method for
	 * {@link com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList#first()}.
	 * When there is more than one element added to the front
	 */
	@Test
	public final void TestFirstWithThreeElementsAddedToFront() {
		Integer expected = new Integer(9);
		list.addToFront(7);
		list.addToFront(8);
		list.addToFront(9);
		assertEquals(expected, list.first());
	}
	
	/**
	 * Test method for
	 * {@link com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList#first()}.
	 * When there is more than one element added to the rear
	 */
	@Test
	public final void testFirstWithThreeElementsAddedToRear() {
		Integer expected = new Integer(9);
		list.addToRear(9);
		list.addToRear(8);
		list.addToRear(7);
		assertEquals(expected, list.first());
	}
	
	/**
	 * Test method for
	 * {@link com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList#first()}.
	 * When there is more than one element added to the front and rear
	 */
	@Test
	public final void testFirstWithElementsAddedToFrontAndRear() {
		Integer expected = new Integer(2);
		list.addToFront(1);
		list.addToRear(9);
		list.addToRear(10);
		list.addToFront(2);
		assertEquals(expected,list.first());
	}
	
	/**
	 * Test method for
	 * {@link com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList#last()}.
	 * When there is more than one element added to the front
	 */
	@Test
	public final void testLastWithThreeElementsAddedToFront() {
		Integer expected = new Integer(7);
		list.addToFront(7);
		list.addToFront(8);
		list.addToFront(9);
		assertEquals(expected, list.last());
	}
	
	/**
	 * Test method for
	 * {@link com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList#last()}.
	 * When there is more than one element added to the rear
	 */
	@Test
	public final void testLastWithThreeElementsAddedToRear() {
		Integer expected = new Integer(7);
		list.addToRear(9);
		list.addToRear(8);
		list.addToRear(7);
		assertEquals(expected, list.last());
	}
	
	/**
	 * Test method for
	 * {@link com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList#last()}.
	 * When there is more than one element added to the front and rear
	 */
	@Test
	public final void testFLastWithElementsAddedToFrontAndRear() {
		Integer expected = new Integer(10);
		list.addToFront(1);
		list.addToRear(9);
		list.addToRear(10);
		list.addToFront(2);
		assertEquals(expected,list.last());
	}
	
	



	/**
	 * Test method for
	 * {@link com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList#isEmpty()}.
	 * Adds and then removes a single element
	 */
	@Test
	public final void testIsEmptyAfterAdditionAndRemoval() {
		list.addToFront(6);
		list.removeFirst();
		assertTrue(list.isEmpty());
	}
	
	/**
	 * Test method for
	 * {@link com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList#isEmpty()}.
	 * Adds two elements and then removes a single element
	 */
	@Test
	public final void testIsEmptyIsFalseAfterAddingTwoElementsAndRemovingOne() {
		list.addToFront(6);
		list.addToFront(7);
		list.removeFirst();
		assertFalse(list.isEmpty());
	}
	

	/**
	 * Test method for
	 * {@link com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList#size()}
	 * after adding elements to the front
	 */
	@Test
	public final void testSizeAfterAddingElementsToFront() {
		int expected = 3;
		list.addToFront(1);
		list.addToFront(2);
		list.addToFront(3);
		assertEquals(expected, list.size());
	}
	
	/**
	 * Test method for
	 * {@link com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList#size()}
	 * after adding elements to the rear
	 */
	@Test
	public final void testSizeAfterAddingElementsToRear() {
		int expected = 3;
		list.addToRear(1);
		list.addToRear(2);
		list.addToRear(3);
		assertEquals(expected, list.size());
	}


}
