/**
 * @author Andrew Asquith
 * COMP 2231 
 * Assignment 3 
 * Common classes used by multiple questions
 */
package com.andrewasquith.comp2231.assignment3.common;

/**
 * Import for Arrays.copyOf
 */
import java.util.Arrays;

/**
 * import the Iterator<T> interface
 */
import java.util.Iterator;

/**
 * import jsjf Interfaces and exceptions
 */
import jsjf.UnorderedListADT;
import jsjf.exceptions.ElementNotFoundException;
import jsjf.exceptions.EmptyCollectionException;

/**
 * UnorderedArrayList implementation based on the jsjf ADT interface
 *
 */
public class UnorderedArrayList<T> implements UnorderedListADT<T> {

	/**
	 * Default initial capacity for the underlying array
	 */
	private final static int INITIAL_CAPACITY = 100;

	/**
	 * Constant to indicate when an element is not found during a search
	 */
	private static final int ELEMENT_NOT_FOUND = -1;

	/**
	 * Internal Array for storage of list elements
	 */
	private T[] internalArray;

	/**
	 * Pointer for the current rear of the list
	 */
	private int rear = -1;

	/**
	 * Default constructor with default capacity
	 */
	public UnorderedArrayList() {
		this(INITIAL_CAPACITY);
	}

	/**
	 * Constructor accepting initial capacity
	 * 
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public UnorderedArrayList(int capacity) {
		internalArray = (T[]) new Object[capacity];
	}

	/**
	 * Helper method to double the capacity of the internal array when necessary
	 */
	private void expandCapacity() {
		internalArray = Arrays.copyOf(internalArray, internalArray.length * 2);
	}

	/**
	 * Helper method to return the index of a given element or ELEMENT_NOT_FOUND
	 * if not present
	 * 
	 * @param element
	 *            the element to search for
	 * @return array index of the target element
	 */
	private int findElement(T target) {

		int targetIndex = ELEMENT_NOT_FOUND;
		if (!isEmpty()) {
			int current = 0;

			while (targetIndex == ELEMENT_NOT_FOUND && current <= rear) {
				if (internalArray[current].equals(target)) {
					targetIndex = current;
				} else {
					current++;
				}
			}
		}

		return targetIndex;
	}

	/**
	 * Removes the first element in the collection and returns it
	 * 
	 * @return the element at the front
	 * @throws EmptyCollectionException
	 *             when collection is empty
	 */
	@Override
	public T removeFirst() throws EmptyCollectionException {

		//if empty, throw
		if (isEmpty()) {
			throw new EmptyCollectionException("UnorderedArrayList");
		}

		// get the current first element
		T result = internalArray[0];

		// shift the remaining elements left
		for (int i = 0; i <= rear; i++) {
			internalArray[i] = internalArray[i + 1];
		}
		// null out the duplicate value at old rear
		internalArray[rear] = null;

		// decrement rear pointer
		rear--;

		// return the requested element
		return result;
	}

	/**
	 * Removes and returns the last element in the collection
	 * 
	 * @return the element at the rear
	 * @throws EmptyCollectionException
	 *             when collection is empty
	 */
	@Override
	public T removeLast() throws EmptyCollectionException {

		//if empty, throw
		if (isEmpty()) {
			throw new EmptyCollectionException("UnorderedArrayList");
		}

		// get the element from the rear
		T result = internalArray[rear];
		// null out the existing rear
		internalArray[rear] = null;
		// decrement rear pointer
		rear--;
		// return the requested element
		return result;

	}

	/**
	 * Removes the requested element from the collection
	 * 
	 * @return the requested element
	 * @throws ElementNotFound
	 *             if the element cannot be found
	 */
	@Override
	public T remove(T element) throws ElementNotFoundException {

		// find the requested element
		int targetIndex = findElement(element);

		if (targetIndex == ELEMENT_NOT_FOUND) {
			// if not found, throw
			throw new ElementNotFoundException("UnorderedArrayList");
		} else {

			// get the requested element
			T result = internalArray[targetIndex];

			// shift the remaining elements left
			for (int i = targetIndex; i <= rear; i++) {
				internalArray[targetIndex] = internalArray[targetIndex + 1];
			}

			// set the old rear to null
			internalArray[rear] = null;

			// decrement the rear counter
			rear--;

			// return the requested element
			return result;

		}
	}

	/**
	 * Returns a reference to the element at the front but does not remove it
	 * 
	 * @return element at the front of the collection
	 * @throws EmptyCollectionException
	 *             when the collection is empty
	 */
	@Override
	public T first() throws EmptyCollectionException {

		// if collection is empty, throw
		if (isEmpty()) {
			throw new EmptyCollectionException("UnorderedArrayList");
		}

		// otherwise return a reference to the element at the front
		return internalArray[0];
	}

	/**
	 * Returns a reference to the element at the rear but does not remove it
	 * 
	 * @return element at the rear of the collection
	 * @throws EmptyCollectionException
	 *             when the collection is empty
	 */
	@Override
	public T last() throws EmptyCollectionException {

		// if empty, throw
		if (isEmpty()) {
			throw new EmptyCollectionException("UnorderedArrayList");
		}

		// return reference to the element at the rear
		return internalArray[rear];
	}

	/**
	 * Determine if the collection contains the requested element
	 * 
	 * @param T
	 *            target the element to search for
	 * @return boolean true if the element is found, false if not
	 */
	@Override
	public boolean contains(T target) {
		return (findElement(target) != ELEMENT_NOT_FOUND);
	}

	/**
	 * Determine if the collection is currently empty
	 * 
	 * @return boolean true if the collection is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return (rear == -1);
	}

	/**
	 * Determine the current number of elements in the collection
	 * 
	 * @return int number of elements in the collection
	 */
	@Override
	public int size() {
		// return the rear pointer + 1 since it's zero based
		return rear + 1;
	}

	/**
	 * Add an element to the front of the collection
	 * 
	 * @param element
	 *            the element to be added to the collection
	 */
	@Override
	public void addToFront(T element) {

		if (rear == internalArray.length - 1) {
			expandCapacity();
		}

		// increment rear
		rear++;

		// shift the existing values
		for (int i = rear; i > 0; i--) {
			internalArray[i] = internalArray[i - 1];
		}

		// add the new element to the front
		internalArray[0] = element;
	}

	/**
	 * Adds an element to the rear of the collection
	 * 
	 * @param element
	 *            the element to add
	 */
	@Override
	public void addToRear(T element) {

		// expand if necessary
		if (rear == internalArray.length - 1) {
			expandCapacity();
		}

		// increment rear
		rear++;

		// no need to shift, just put in place
		internalArray[rear] = element;

	}

	/**
	 * Adds an element after the specified element
	 * 
	 * @param element
	 *            the element to add to the collection
	 * @param target
	 *            the element after which the new element should be added
	 * @throws ElementNotFoundException
	 *             if the target element cannot be found
	 */
	@Override
	public void addAfter(T element, T target) throws ElementNotFoundException {

		if (isEmpty()) {
			// if the collection is empty, throw
			throw new ElementNotFoundException("UnorderedArrayList");
		}

		// get the index of the target to insert after
		int targetIndex = findElement(target);

		if (targetIndex == ELEMENT_NOT_FOUND) {
			// if the target was not found, throw
			throw new ElementNotFoundException("UnorderedArrayList");
		} else {

			// expand internal array if necessary
			if (rear == internalArray.length - 1) {
				expandCapacity();
			}

			// increment rear pointer
			rear++;

			// shift elements to make room
			for (int i = rear; i > targetIndex; i--) {
				internalArray[i] = internalArray[i - 1];
			}

			// put the new element in place
			internalArray[targetIndex + 1] = element;

		}
	}

	/**
	 * Returns an iterator for the collection
	 * 
	 * @return Iterator<T> Generic iterator for the collection
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
