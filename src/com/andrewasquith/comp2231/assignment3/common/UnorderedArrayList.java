/**
 * 
 */
package com.andrewasquith.comp2231.assignment3.common;

import java.util.Arrays;
import java.util.Iterator;

import jsjf.UnorderedListADT;

/**
 * @author Andrew
 *
 */
public class UnorderedArrayList<T> implements UnorderedListADT<T> {

	private final static int INITIAL_CAPACITY = 100;

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

	@Override
	public T removeFirst() {
		rear--;
		return null;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T first() {

		return internalArray[0];
	}

	@Override
	public T last() {

		return internalArray[rear];
	}

	@Override
	public boolean contains(T target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (rear == -1);
	}

	@Override
	public int size() {
		//return the rear pointer + 1 since it's zero based
		return rear + 1;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addToFront(T element) {
		
		if (rear == internalArray.length -1) {
			expandCapacity();
		}
		
		//increment rear
		rear++;

		//shift the existing values
		for(int i=rear; i>0; i--) {
			internalArray[rear] = internalArray[rear - 1];
		}
		
		//add the new element to the front
		internalArray[0] = element;
	}

	/**
	 * Helper method to double the capacity of the internal array when necessary
	 */
	private void expandCapacity() {
		internalArray = Arrays.copyOf(internalArray,  internalArray.length * 2);
		
	}

	@Override
	public void addToRear(T element) {
		
		if (rear == internalArray.length -1) {
			expandCapacity();
		}
		//increment rear
		rear++;
		
		//no need to shift, just put in place
		internalArray[rear] = element;

	}

	@Override
	public void addAfter(T element, T target) {
		// TODO Auto-generated method stub

	}

}
