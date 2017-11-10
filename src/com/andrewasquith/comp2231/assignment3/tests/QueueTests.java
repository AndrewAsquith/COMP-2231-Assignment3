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
import jsjf.QueueADT;
import jsjf.exceptions.EmptyCollectionException;

/**
 * Abstract Queue Test Fixture
 * Exercises classes implementing QueueADT functionality
 * Individual test fixtures should inherit this class and provide the class 
 * under test in the setUp() method
 *
 */
public abstract class QueueTests {

	/**
	 * The Queue interface classes under test must adhere to
	 */
	QueueADT<Integer> queue;
	
	/**
	 * Test that isEmpty returns true when the collection is empty
	 */
	@Test
	public final void testIsEmptyReturnsTrueWhenCollectionEmpty() {
		assertTrue(queue.isEmpty());
	}
	
	/**
	 * Test that isEmpty returns false when there are elements in the collection
	 */
	@Test
	public final void testIsEmptyReturnsFalseWhenCollectionNotEmpty() {
		queue.enqueue(1);
		assertFalse(queue.isEmpty());
	}
	
	/**
	 * Test that size returns the correct value when the collection is empty
	 */
	@Test
	public final void testSizeReturnsZeroWhenCollectionIsEmpty() {
		assertEquals(0, queue.size());
	}
	
	/**
	 * Test that size returns the correct value when the collection is not empty
	 */
	@Test
	public final void testSizeReturnsCorrectValueWhenCollectionNotEmpty() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		assertEquals(3, queue.size());
	}
	
	/**
	 * Test that first returns the correct element when the collection only contains one
	 */
	@Test
	public final void testFirstReturnsCorrectElementWhenCollectionHasOneElement() {
		queue.enqueue(1);
		assertEquals(new Integer(1), queue.first());
	}
	
	/**
	 * Test that first returns the correct element when the collection has multiple elements
	 */
	@Test 
	public final void testFirstReturnsCorrectElementWhenCollectionHasMultipleElements() {
		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals(new Integer(0), queue.first());
	}
	
	/**
	 * Test that first throws when called on an empty collection
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void testFirstThrowsEmptyCollectionExceptionWhenCollectionEmpty() {
		queue.first();
	}
	
	/**
	 * Test that first throws after elements are added and then the collection is emptied
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void testFirstThrowsEmptyCollectionExceptionAfterCollectionIsEmptied() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.dequeue();
		queue.dequeue();
		queue.first(); //this should throw
	}
		
	/**
	 * Test that first leaves the element in the collection
	 */
	@Test
	public final void testFirstLeavesElementInCollection() {
		queue.enqueue(1);
		queue.first();
		assertEquals(new Integer(1), queue.first());
	}
	
	/**
	 * Test that dequeue returns the correct element when there is only one
	 */
	@Test
	public final void testDequeueReturnsCorrectElementWhenCollectionHasOneElement() {
		queue.enqueue(1);
		assertEquals(new Integer(1), queue.dequeue());
	}
	
	/**
	 * Test that dequeue returns the correct element when there are more than one element
	 */
	@Test
	public final void testDequeueReturnsCorrectElementWhenCollectionHasMultipleElements() {
		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals(new Integer(1), queue.dequeue());
	}
	
	/**
	 * Test that dequeue throws when there are no elements
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void testDequeueThrowsEmptyCollectionExceptionWhenCollectionEmpty() {
		queue.dequeue();
	}
	
	/**
	 * Test that after putting elements on and dequeueping them the collection empties and throws
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void testDequeueThrowsEmptyCollectionExceptionAfterCollectionIsEmptied() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue(); // this should throw
	}
	
	/**
	 * Test that enqueue and dequeue multiple values works as intended
	 */
	@Test
	public final void testMultipleEnqueueAndDequeueReturnsCorrectValues() {
		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals(new Integer(1), queue.dequeue());
		queue.enqueue(3);
		assertEquals(new Integer(2), queue.dequeue());
		assertEquals(new Integer(3), queue.dequeue());
	}
	
	/**
	 * Test that size returns zero after multiple enqueue and dequeue operations
	 */
	@Test
	public final void testSizeReturnsZeroAfterMultipleEnqueueAndDequeues() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.dequeue();
		queue.dequeue();
		assertEquals(0, queue.size());
	}
	
	/**
	 * Test that size returns the correct value after multiple enqueue and dequeue operations
	 */
	@Test
	public final void testSizeRetursCorrectValueAfterMultipleEnqueueAndDequeues() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(4);
		assertEquals(2, queue.size());
	}
	
}
