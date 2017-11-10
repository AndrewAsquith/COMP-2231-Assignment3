/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 3
 * Question 2 - Stack implemented with an ArrayList 
 */
package com.andrewasquith.comp2231.assignment3.question2;

/**
 * Import the parent class defining the functionality and the list implementation
 */
import com.andrewasquith.comp2231.assignment3.common.UnordedListStack;
import com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList;

/**
 * ArrayList backed Stack implementation
 *
 * @param <T> the generic type of the stack 
 */
public class ArrayListStack<T> extends UnordedListStack<T> {

	/**
	 * Constructor calls the parent's with the specific list implementation
	 */
	public ArrayListStack() {
		super(new UnorderedArrayList<T>());
	}
	

}
