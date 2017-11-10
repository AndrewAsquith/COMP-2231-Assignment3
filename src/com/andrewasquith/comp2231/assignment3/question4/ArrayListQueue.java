/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 3
 * Question 4 - Queue implemented with an ArrayList 
 */
package com.andrewasquith.comp2231.assignment3.question4;

/**
 * Import the parent class defining the functionality and the list implementation
 */
import com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList;
import com.andrewasquith.comp2231.assignment3.common.UnorderedListQueue;

/**
 * ArrayList backed Queue implementation
 *
 * @param <T> the generic type of the queue 
 */
public class ArrayListQueue<T> extends UnorderedListQueue<T> {

	/**
	 * Constructor calls the parent's with the specific list implementation
	 */
	public ArrayListQueue() {
		super(new UnorderedArrayList<T>());
	}

}
