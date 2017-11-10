/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 3
 * Question 1 - Stack implemented with an ArrayList 
 */
package com.andrewasquith.comp2231.assignment3.question1;

/**
 * Import the parent class defining the functionality and the list implementation
 */
import com.andrewasquith.comp2231.assignment3.common.UnordedListStack;
import com.andrewasquith.comp2231.assignment3.common.UnorderedLinkedList;

/**
 * LinkedList backed Stack implementation
 *
 * @param <T> the generic type of the stack 
 */
public class LinkedListStack<T> extends UnordedListStack<T> {

	/**
	 * Constructor calls the parent's with the specific list implementation
	 */
	public LinkedListStack() {
		super(new UnorderedLinkedList<T>());
	}
	

}
