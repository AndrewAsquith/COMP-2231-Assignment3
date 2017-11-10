/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 3
 * Unit Test Classes
 */
package com.andrewasquith.comp2231.assignment3.tests;

/**
 * JUnit assertions
 */
import static org.junit.Assert.*;

/**
 * JUnit Test Attribute
 */
import org.junit.Test;

/**
 * Import the required interface and exception
 */
import jsjf.StackADT;
import jsjf.exceptions.EmptyCollectionException;

/**
 * Abstract Stack Test Fixture
 * Exercises classes implementing StackADT functionality
 * Individual test fixtures should inherit this class and provide the class 
 * under test in the setUp() method
 *
 */
public abstract class StackTests {

	/**
	 * The Stack interface classes under test must adhere to
	 */
	StackADT<Integer> stack;
	
	/**
	 * Test that isEmpty returns true when the collection is empty
	 */
	@Test
	public final void testIsEmptyReturnsTrueWhenCollectionEmpty() {
		assertTrue(stack.isEmpty());
	}
	
	/**
	 * Test that isEmpty returns false when there are elements in the collection
	 */
	@Test
	public final void testIsEmptyReturnsFalseWhenCollectionNotEmpty() {
		stack.push(1);
		assertFalse(stack.isEmpty());
	}
	
	/**
	 * Test that size returns the correct value when the collection is empty
	 */
	@Test
	public final void testSizeReturnsZeroWhenCollectionIsEmpty() {
		assertEquals(0, stack.size());
	}
	
	/**
	 * Test that size returns the correct value when the collection is not empty
	 */
	@Test
	public final void testSizeReturnsCorrectValueWhenCollectionNotEmpty() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertEquals(3, stack.size());
	}
	
	/**
	 * Test that peek returns the correct element when the collection only contains one
	 */
	@Test
	public final void testPeekReturnsCorrectElementWhenCollectionHasOneElement() {
		stack.push(1);
		assertEquals(new Integer(1), stack.peek());
	}
	
	/**
	 * Test that peek returns the correct element when the collection has multiple elements
	 */
	@Test 
	public final void testPeekReturnsCorrectElementWhenCollectionHasMultipleElements() {
		stack.push(0);
		stack.push(1);
		stack.push(2);
		assertEquals(new Integer(2), stack.peek());
	}
	
	/**
	 * Test that peek throws when called on an empty collection
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void testPeekThrowsEmptyCollectionExceptionWhenCollectionEmpty() {
		stack.peek();
	}
	
	/**
	 * Test that peek throws after elements are added and then the collection is emptied
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void testPeekThrowsEmptyCollectionExceptionAfterCollectionIsEmptied() {
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.pop();
		stack.peek(); //this should throw
	}
		
	/**
	 * Test that peek leaves the element in the collection
	 */
	@Test
	public final void testPeekLeavesElementInCollection() {
		stack.push(1);
		stack.peek();
		assertEquals(new Integer(1), stack.peek());
	}
	
	/**
	 * Test that pop returns the correct element when there is only one
	 */
	@Test
	public final void testPopReturnsCorrectElementWhenCollectionHasOneElement() {
		stack.push(1);
		assertEquals(new Integer(1), stack.pop());
	}
	
	/**
	 * Test that pop returns the correct element when there are more than one element
	 */
	@Test
	public final void testPopReturnsCorrectElementWhenCollectionHasMultipleElements() {
		stack.push(1);
		stack.push(2);
		assertEquals(new Integer(2), stack.pop());
	}
	
	/**
	 * Test that pop throws when there are no elements
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void testPopThrowsEmptyCollectionExceptionWhenCollectionEmpty() {
		stack.pop();
	}
	
	/**
	 * Test that after putting elements on and popping them the collection empties and throws
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void testPopThrowsEmptyCollectionExceptionAfterCollectionIsEmptied() {
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.pop();
		stack.pop(); // this should throw
	}
	
	/**
	 * Test that pushing and popping multiple values works as intended
	 */
	@Test
	public final void testMultiplePushAndPopReturnsCorrectValues() {
		stack.push(1);
		stack.push(2);
		assertEquals(new Integer(2), stack.pop());
		stack.push(3);
		assertEquals(new Integer(3), stack.pop());
		assertEquals(new Integer(1), stack.pop());
	}
	
	/**
	 * Test that size returns zero after multiple push and pop operations
	 */
	@Test
	public final void testSizeReturnsZeroAfterMultiplePushAndPops() {
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.pop();
		assertEquals(0, stack.size());
	}
	
	/**
	 * Test that size returns the correct value after multiple push and pop operations
	 */
	@Test
	public final void testSizeRetursCorrectValueAfterMultiplePushAndPops() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		stack.pop();
		stack.push(4);
		assertEquals(2, stack.size());
	}
	
}
