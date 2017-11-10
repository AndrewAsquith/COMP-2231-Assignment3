/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 3
 * Unit Test Classes
 */
package com.andrewasquith.comp2231.assignment3.tests;

/**
 * Junit assertions
 */
import static org.junit.Assert.*;

/**
 * JUnit Test Attribute
 */
import org.junit.Test;

/**
 * Other API interfaces and exceptions
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

/**
 * Interface classes under test will implement
 */
import jsjf.UnorderedListADT;
/**
 * Required exceptions for expectations
 */
import jsjf.exceptions.ElementNotFoundException;
import jsjf.exceptions.EmptyCollectionException;

/**
 * Abstract UnorderedList Test Fixture
 * Exercises classes implementing UnorderedList functionality and it's Iterator
 * Individual test fixtures should inherit this class and provide the class 
 * under test in the setUp() method
 *
 */
public abstract class UnorderedListTests {

	/**
	 * List implementation must adhere to the UnorderedListADT<T> interface
	 */
	UnorderedListADT<Integer> list;


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
	 * Test first returns correctly when there is a single element.
	 */
	@Test
	public final void testFirstWithSingleElement() {
		Integer expected = new Integer(7);
		list.addToFront(expected);
		assertEquals(expected, list.first());
	}

	/**
	 * Test last returns correctly  when there is a single element.
	 */
	@Test
	public final void testLastWithSingleElement() {
		Integer expected = new Integer(7);
		list.addToFront(expected);
		assertEquals(expected, list.last());
	}

	/**
	 * Test first returns correctly when there is more than one element added to the front
	 */
	@Test
	public final void testFirstWithThreeElementsAddedToFront() {
		Integer expected = new Integer(9);
		list.addToFront(7);
		list.addToFront(8);
		list.addToFront(9);
		assertEquals(expected, list.first());
	}
	
	/**
	 * Test first returns correctly when there is more than one element added to the rear
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
	 * Test first returns correctly when there is more than one element added to the front and rear
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
	 * Test last returns correctly when there is more than one element added to the front
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
	 * Test last returns correctly when there is more than one element added to the rear
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
	 * Test last returns correctly when there is more than one element added to the front and rear
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
	 * Test is empty is true after adding and then removing a single element
	 */
	@Test
	public final void testIsEmptyAfterAdditionAndRemoval() {
		list.addToFront(6);
		list.removeFirst();
		assertTrue(list.isEmpty());
	}
	
	/**
	 * Test is empty is false after adding two elements and then removing a single element
	 */
	@Test
	public final void testIsEmptyIsFalseAfterAddingTwoElementsAndRemovingOne() {
		list.addToFront(6);
		list.addToFront(7);
		list.removeFirst();
		assertFalse(list.isEmpty());
	}
	
	/**
	 * Test that removeFirst removes the first element
	 */
	@Test
	public final void testRemoveFirstRemovesFirstElement() {
		list.addToFront(1);
		list.addToFront(2);
		Integer result = list.removeFirst();
		assertEquals(result, new Integer(2));
		assertEquals(new Integer(1), list.first());
	}
	
	/**
	 * Test that removeLast removes the last element
	 */
	public final void testRemoveLastRemovesLastElement() {
		list.addToFront(1);
		list.addToRear(2);
		Integer result = list.removeLast();
		assertEquals(result, new Integer(2));
		assertEquals(new Integer(1), list.last());
	}
	
	/**
	 * Test that remove removes the correct element
	 */
	@Test
	public final void testRemoveSpecifiedElementRemovesCorrectElement() {
		list.addToFront(1);
		list.addToFront(2);
		list.addToFront(3);
		Integer result = list.remove(2);
		Integer[] expected = { new Integer(3), new Integer(1) };
		assertEquals(new Integer(2), result);
		
		Integer[] actual = new Integer[2];

		for (int i = 0; i < 2; i++) {
			actual[i] = list.removeFirst();
		}
		
		assertArrayEquals(expected, actual);
		
	}
	
	/**
	 * Test that contains returns true when the element is present
	 */
	@Test
	public final void testContainsReturnsTrueWhenElementPresent() {
		list.addToFront(1);
		list.addToFront(2);
		list.addToFront(3);
		assertTrue(list.contains(2));
	}
	
	/**
	 * Test that contains returns false when the element is not present
	 */
	@Test
	public final void testContainsReturnsFalseWhenElementNotPresent() {
		list.addToFront(1);
		list.addToFront(2);
		list.addToFront(3);
		assertFalse(list.contains(4));
	}
	
	/**
	 * Test that addAfter inserts the element in the correct position
	 */
	@Test
	public final void testAddAfterAddsElementToCorrectPosition() {
		list.addToFront(1);
		list.addToFront(2);
		list.addToFront(3);
		list.addAfter(4, 2);
		
		Integer[] expected = { new Integer(3), new Integer(2), new Integer(4), new Integer(1) };
		Integer[] actual = new Integer[4];

		for (int i = 0; i < 4; i++) {
			actual[i] = list.removeFirst();
		}
		
		assertArrayEquals(expected, actual);
	}
	
	/**
	 * Test that first throws EmptyCollectionException when collection is empty
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void testFirstThrowsEmptyCollectionExceptionWhenEmpty() {
		list.first();
	}
	
	/**
	 * Test that removeFirst throws EmptyCollectionException when collection is empty
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void testRemoveFirstThrowsEmptyCollectionExceptionWhenEmpty() {
		list.removeFirst();
	}

	/**
	 * Test that the collection throws ElementNotFoundException when attempting
	 * to remove element that does not exist
	 */
	@Test(expected = ElementNotFoundException.class)
	public final void testRemoveThrowsElementNotFoundExceptionWhenElementNotFound() {
		list.addToFront(1);
		list.addToFront(2);
		list.addToFront(3);
		list.remove(4);
	}
	
	/**
	 * Test that last throws EmptyCollectionException when collection is empty
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void testLastThrowsEmptyCollectionExceptionWhenEmpty() {
		list.last();
	}
	
	/**
	 * Test that removeLast throws EmptyCollectionException when collection is empty
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void testRemoveLastThrowsEmptyCollectionExceptionWhenEmpty() {
		list.removeLast();
	}
	
	/**
	 * Test that the iterator iterates all elements
	 */
	@Test
	public final void testIteratorIteratesAllElements() {
		Integer[] expected = { new Integer(3), new Integer(2), new Integer(1) };
		list.addToFront(1);
		list.addToFront(2);
		list.addToFront(3);
		Iterator<Integer> itr = list.iterator();
		Integer[] actual = new Integer[3];
		for (int i = 0; i <3; i++) {
			actual[i] = itr.next();
		}
		assertArrayEquals(expected, actual);
	}
	
	/**
	 * Test that the iterator hasNext returns true when there are more elements
	 */
	@Test
	public final void testIteratorHasNextIsTrueWhenMoreElements() {
		list.addToFront(1);
		list.addToFront(2);
		list.addToFront(3);
		list.addToFront(4);
		Iterator<Integer> itr = list.iterator();
		if (itr.hasNext()) {
			itr.next();
		}
		assertTrue(itr.hasNext());
	}
	
	/**
	 * Test the iterator hasNext returns true on an empty collection
	 */
	public final void testIteratorHasNextIsFalseWhenEmptyCollection() {
		Iterator<Integer> itr = list.iterator();
		assertFalse(itr.hasNext());
	}
	
	/**
	 * Test that the iterator hasNext returns false when there are no more elements
	 */
	@Test
	public final void testIteratorHasNextIsFalseWhenNoMoreElements() {
		Iterator<Integer> itr = list.iterator();
		assertFalse(itr.hasNext());
	}
	
	/**
	 * Test that the iterator returns the correct element when calling next
	 */
	@Test
	public final void testIteratorNextReturnsCorrectElement() {
		list.addToFront(1);
		list.addToFront(2);
		Iterator<Integer> itr = list.iterator();
		itr.next(); //discard the 2
		assertEquals(new Integer(1), itr.next());
	}
	
	/**
	 * Test the iterator throws NoSuchElementException when calling next when no more elements
	 */
	@Test(expected = NoSuchElementException.class) 
	public final void testIteratorThrowsNoSuchElementExceptionWhenNoMoreElements() {
		list.addToFront(1);
		list.addToFront(2);
		Iterator<Integer> itr = list.iterator();
		itr.next();
		itr.next();
		itr.next(); //should throw
	}
	
	/**
	 * Test the iterator throws a ConcurrentModificationException if modified during use
	 * by calling AddToFront on the list
	 */
	@Test(expected = ConcurrentModificationException.class)
	public final void testIteratorThrowsConcurrentModificationExceptionWhenAddToFrontCalled() {
		list.addToFront(1);
		list.addToFront(2);
		Iterator<Integer> itr = list.iterator();
		list.addToFront(3);
		itr.hasNext(); //this should throw
	}
	
	/**
	 * Test the iterator throws a ConcurrentModificationException if modified during use
	 * by calling AddToRear on the list
	 */
	@Test(expected = ConcurrentModificationException.class)
	public final void testIteratorThrowsConcurrentModificationExceptionWhenAddToRearCalled() {
		list.addToFront(1);
		list.addToFront(2);
		Iterator<Integer> itr = list.iterator();
		list.addToRear(3);
		itr.hasNext(); //this should throw
	}
	
	/**
	 * Test the iterator throws a ConcurrentModificationException if modified during use
	 * by calling RemoveFirst on the list
	 */
	@Test(expected = ConcurrentModificationException.class)
	public final void testIteratorThrowsConcurrentModificationExceptionWhenRemoveFirstCalled() {
		list.addToFront(1);
		list.addToFront(2);
		Iterator<Integer> itr = list.iterator();
		list.removeFirst();
		itr.hasNext(); //this should throw
	}
	
	/**
	 * Test the iterator throws a ConcurrentModificationException if modified during use
	 * by calling RemoveLast on the list
	 */
	@Test(expected = ConcurrentModificationException.class)
	public final void testIteratorThrowsConcurrentModificationExceptionWhenRemoveLastCalled() {
		list.addToFront(1);
		list.addToFront(2);
		Iterator<Integer> itr = list.iterator();
		list.removeLast();
		itr.hasNext(); //this should throw
	}
	
	/**
	 * Test the iterator throws a ConcurrentModificationException if modified during use
	 * by calling Remove on the list
	 */
	@Test(expected = ConcurrentModificationException.class)
	public final void testIteratorThrowsConcurrentModificationExceptionWhenRemoveCalled() {
		list.addToFront(1);
		list.addToFront(2);
		Iterator<Integer> itr = list.iterator();
		list.remove(1);
		itr.hasNext(); //this should throw
	}
	
	/**
	 * Test the iterator throws a ConcurrentModificationException if modified during use
	 * by calling AddAfter on the list
	 */
	@Test(expected = ConcurrentModificationException.class)
	public final void testIteratorThrowsConcurrentModificationExceptionWhenAddAfterCalled() {
		list.addToFront(1);
		list.addToFront(2);
		Iterator<Integer> itr = list.iterator();
		list.addAfter(3,1);
		itr.hasNext(); //this should throw
	}

	/**
	 * Test the iterator throws UnsupportedOperationException when calling remove
	 */
	@Test(expected = UnsupportedOperationException.class)
	public final void testIteratorThrowsUnsupportedOperationExceptionWhenCallingRemove() {
		Iterator<Integer> itr = list.iterator();
		itr.remove();
	}
}
