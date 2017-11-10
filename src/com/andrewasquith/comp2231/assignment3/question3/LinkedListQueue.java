/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 3
 * Question 3 - Queue implemented with an LinkedList 
 */
package com.andrewasquith.comp2231.assignment3.question3;

/**
 * Import the parent class defining the functionality and the list implementation
 */
import com.andrewasquith.comp2231.assignment3.common.UnorderedLinkedList;
import com.andrewasquith.comp2231.assignment3.common.UnorderedListQueue;

/**
 * LinkedList backed Queue implementation
 *
 * @param <T> the generic type of the queue 
 */
public class LinkedListQueue<T> extends UnorderedListQueue<T> {

	/**
	 * Constructor calls the parent's with the specific list implementation
	 */
	public LinkedListQueue() {
		super(new UnorderedLinkedList<T>());
	}

}
