package com.andrewasquith.comp2231.assignment3.common;

import jsjf.StackADT;
import jsjf.UnorderedListADT;
import jsjf.exceptions.EmptyCollectionException;

public class UnordedListStack<T> implements StackADT<T> {

	/**
	 * The list implementation that backs the stack
	 */
	private UnorderedListADT<T> list;

	public UnordedListStack(UnorderedListADT<T> listImplementation) {
		
		//accept the implementation to use via constructor
		list = listImplementation;
	}

	/**
	 * Pushes the element onto the stack
	 * 
	 * @param T
	 *            the element to add to the stack
	 */
	@Override
	public void push(T element) {
		// we're going to use the front since it's easier conceptually
		// the list would handle using the front or rear, as long as it's
		// consistent
		list.addToFront(element);

	}

	/**
	 * Removes the element from the top of the stack
	 * 
	 * @return T element at the top of the stack
	 */
	@Override
	public T pop() {

		try {
			// return the element from the front of the list
			return list.removeFirst();

		} catch (EmptyCollectionException e) {
			
			// if the list throws, catch and re-throw
			throw new EmptyCollectionException("Stack");
		}
	}

	/**
	 * Return a reference to the element at the top of the stack without
	 * removing it from the stack
	 * 
	 * @return T element at the top of the stack
	 */
	@Override
	public T peek() throws EmptyCollectionException {

		try {
			// return the element from the front of the list
			return list.first();

		} catch (EmptyCollectionException e) {

			// if the list throws, catch and re-throw
			throw new EmptyCollectionException("Stack");
		}

	}

	/**
	 * Determine if the stack is currently empty
	 * 
	 * @return boolean true if empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Determine the number of elements currently in the collection
	 * 
	 * @return int number of elements on the stack
	 */
	@Override
	public int size() {
		return list.size();
	}

}
