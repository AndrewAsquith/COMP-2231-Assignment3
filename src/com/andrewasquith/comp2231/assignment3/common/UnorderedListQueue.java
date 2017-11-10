package com.andrewasquith.comp2231.assignment3.common;

import jsjf.QueueADT;
import jsjf.UnorderedListADT;
import jsjf.exceptions.EmptyCollectionException;

public class UnorderedListQueue<T> implements QueueADT<T> {

	//the list implementation that backs the queue
	private UnorderedListADT<T> list;

	public UnorderedListQueue(UnorderedListADT<T> listImplementation) {
		
		//accept the list implementation to use via constructor
		list = listImplementation;
	}
	
	/**
	 * Add a new element to the queue
	 * @param T the element to add to the queue
	 */
	@Override
	public void enqueue(T element) {

		// add the element to the front of the list
		list.addToFront(element);

	}

	/**
	 * Remove and return the first element in the queue
	 * 
	 * @return T the element that was removed
	 * @throws EmptyCollectionException
	 *             if the queue is empty
	 */
	@Override
	public T dequeue() {

		try {
			// the list ist naturally a queue, add to front, take from rear
			return list.removeLast();
		} catch (EmptyCollectionException e) {

			// if the list throws, catch and re-throw
			throw new EmptyCollectionException("Queue");
		}
	}

	/**
	 * Return a reference to the first element in the queue
	 * 
	 * @return T the first element in the queue
	 * @throws EmptyCollectionException
	 *             if the queue is empty
	 */
	@Override
	public T first() throws EmptyCollectionException {

		try {
			// the list is naturally a queue, add to front, take from rear
			return list.last();
		} catch (EmptyCollectionException e) {
			// if the list throws, catch and re-throw
			throw new EmptyCollectionException("Queue");
		}
	}

	/**
	 * Determine if the queue is empty
	 * 
	 * @return boolean true if the queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Determine the size of the queue
	 * 
	 * @return int the number of elements in the queue
	 */
	@Override
	public int size() {
		return list.size();
	}
}
