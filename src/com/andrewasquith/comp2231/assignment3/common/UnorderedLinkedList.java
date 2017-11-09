/**
 * 
 */
package com.andrewasquith.comp2231.assignment3.common;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import jsjf.LinearNode;
import jsjf.UnorderedListADT;
import jsjf.exceptions.ElementNotFoundException;
import jsjf.exceptions.EmptyCollectionException;

/**
 * @author Andrew
 *
 */
public class UnorderedLinkedList<T> implements UnorderedListADT<T> {

	/**
	 * Pointer to front element
	 */
	private LinearNode<T> front;

	/**
	 * Pointer to rear element
	 */
	private LinearNode<T> rear;

	/**
	 * Counter for the number of elements in the list
	 */
	private int elementCount;

	/**
	 * Modification counter for the fail fast iterator
	 */
	private int modCount;

	/**
	 * Constructor initializing the counters and pointers
	 */
	public UnorderedLinkedList() {

		// list is empty, set front and rear to null
		front = null;
		rear = null;

		// set the counters to 0
		elementCount = 0;
		modCount = 0;

	}

	/**
	 * Removes the first element from the list and returns it
	 * @return T the first element in the list
	 */
	@Override
	public T removeFirst() throws EmptyCollectionException {

		// if no elements, throw
		if (isEmpty()) {
			throw new EmptyCollectionException("UnorderedLinkedList");
		}

		LinearNode<T> result = front;

		// decrement the element counter
		elementCount--;

		if (isEmpty()) {

			// if empty now, that was the last node
			front = null;
			rear = null;

		} else {

			// change the front pointer to the next node in the list
			front = front.getNext();
		}

		// increment the modification counter
		modCount++;

		// return the element from the original head
		return result.getElement();

	}

	/**
	 * Removes the last element from the list and return it
	 * @return T the last element in the list
	 */
	@Override
	public T removeLast() throws EmptyCollectionException {

		// if no elements, throw
		if (isEmpty()) {
			throw new EmptyCollectionException("UnorderedLinkedList");
		}

		// get the requested node from the rear
		LinearNode<T> result = rear;

		// decrement the element counter
		elementCount--;

		if (isEmpty()) {

			// if is empty now, that was the last node
			front = null;
			rear = null;

		} else {

			// could have avoided the traversal with a doubly linked list
			LinearNode<T> current = front;

			// scan to the second last node
			while (current.getNext() != rear) {
				current = current.getNext();
			}

			// set the next node to null
			current.setNext(null);

			// update the rear pointer
			rear = current;
		}

		// increment the modification count
		modCount++;

		// return the requested element
		return result.getElement();

	}

	/**
	 * Remove the requested element from the list
	 * @param target the element to search for
	 * @return the target element
	 * @throws EmptyCollectionException
	 *             when there are no elements
	 */
	@Override
	public T remove(T target) throws EmptyCollectionException {

		// if no elements, throw
		if (isEmpty()) {
			throw new EmptyCollectionException("UnorderedLinkedList");
		}

		T result;

		boolean found = false;

		// start at the beginning of the list
		LinearNode<T> current = front;

		while (!found && current.getNext() != null) {

			// search the node ahead for the requested element
			found = current.getNext().getElement().equals(target);

			// if not correct, move on
			if (!found) {
				current = current.getNext();
			}
		}

		if (found) {

			// store the target for returning
			LinearNode<T> foundTarget = current.getNext();
			result = foundTarget.getElement();

			// set the current node next to the target node's next
			current.setNext(foundTarget.getNext());

		} else {

			// if it wasn't found, throw
			throw new ElementNotFoundException("UnorderedLinkedList");
		}
		
		//increment the modification counter
		modCount++;
		
		//decrement the element counter
		elementCount--;

		return result;
	}

	/**
	 * Return a reference to the element at the front of the list without
	 * removing it
	 * 
	 * @return the element at the front of the list
	 * @throws EmptyCollectionException
	 *             when there are no elements
	 */
	@Override
	public T first() throws EmptyCollectionException {

		// if no elements, throw
		if (isEmpty()) {
			throw new EmptyCollectionException("UnorderedLinkedList");
		}

		// return the element at the front
		return front.getElement();
	}

	/**
	 * Return a reference to the element at the rear of the collection without
	 * removing it
	 * 
	 * @return the element at the rear of the list
	 * @throws EmptyCollectionException
	 *             when there are no elements
	 */
	@Override
	public T last() throws EmptyCollectionException {

		// if no elements, throw
		if (isEmpty()) {
			throw new EmptyCollectionException("UnorderedLinkedList");
		}

		// return the element at the front
		return rear.getElement();
	}

	/**
	 * Determine if the specified element exists in the list
	 * @param target the element to search for
	 * @return boolean true if found, false if not
	 */
	@Override
	public boolean contains(T target) {

		boolean found = false;

		// start at the beginning of the list
		LinearNode<T> current = front;

		while (!found && current.getNext() != null) {

			// search the nodes for the requested element
			found = current.getElement().equals(target);

			// if not correct, move on
			if (!found) {
				current = current.getNext();
			}
		}

		return found;

	}

	/**
	 * Determine if the collection is empty
	 * 
	 * @return boolean true if no elements, false if not
	 */
	@Override
	public boolean isEmpty() {
		return (elementCount == 0);
	}

	/**
	 * Determine the number of elements in the collection
	 * 
	 * @return int the number of elements
	 */
	@Override
	public int size() {
		return elementCount;
	}

	/**
	 * Adds the element to the front of the list
	 * @param element the element to add
	 */
	@Override
	public void addToFront(T element) {

		// create a new node for the element
		LinearNode<T> newNode = new LinearNode<T>(element);

		// set the new elements next pointer to existing front
		newNode.setNext(front);

		// set the front pointer to the new element
		front = newNode;

		if (isEmpty()) {

			// this is the first element in the list, update rear too
			rear = newNode;

		}

		// increase the counters
		elementCount++;
		modCount++;

	}

	/**
	 * Adds an element to the rear of the list
	 * @param element the element to add
	 */
	@Override
	public void addToRear(T element) {

		// create a new node for the element
		LinearNode<T> newNode = new LinearNode<T>(element);

		if (isEmpty()) {
			// this is the first element
			front = newNode;
			rear = newNode;
		} else {
			// set the existing rear next to the new element
			rear.setNext(newNode);

			// update the rear pointer to the new element
			rear = newNode;
		}

		// increment the counters
		elementCount++;
		modCount++;

	}

	/**
	 * Adds a new element after the specifed target element
	 * @param element the element to add
	 * @param target the element to add after
	 * @throws ElementNotFoundException when the target is not present in the list
	 */
	@Override
	public void addAfter(T element, T target) throws ElementNotFoundException {

		if (isEmpty()) {
			throw new ElementNotFoundException("UnorderedLinkedList");
		}

		
		boolean found = false;

		// start at the beginning of the list
		LinearNode<T> current = front;

		while (!found && current != null) {

			// search the nodes for the requested element
			found = current.getElement().equals(target);

			// if not correct, move on
			if (!found) {
				current = current.getNext();
			}
		}

		if (found) {

			//create a new node for the element
			LinearNode<T> newNode = new LinearNode<T>(element);

			//set the new nodes next to found location next
			newNode.setNext(current.getNext());
			
			//set current next to new node
			current.setNext(newNode);

		} else {

			// if it wasn't found, throw
			throw new ElementNotFoundException("UnordedLinkedList");
		}
		
		//increase the counters
		modCount++;
		elementCount++;
	}

	/**
	 * Creates an iterator for this collection
	 */
	@Override
	public Iterator<T> iterator() {
		
		return new UnorderedLinkedListIterator();
	}
	
	/**
	 * Iterator class for the UnorderedLinkedLisk
	 * @author Andrew
	 *
	 */
	private class UnorderedLinkedListIterator implements Iterator<T> {

		/**
		 * The current node in the list
		 */
		private LinearNode<T> current;
		
		/**
		 * iterator intial mod count to support failing fast
		 */
		private int iteratorModCount;
		
		public UnorderedLinkedListIterator() {
			
			//set the mod count to intial value
			iteratorModCount = modCount;
			
			//set current to the front of the list
			current = front;
		}
		
		/**
		 * Determine if there are more elements in the collection
		 * @return boolean true if more elements, false if not
		 * @throws ConcurrentModificationException if the collection has been modified
		 */
		@Override
		public boolean hasNext() {
			
			// if the collection was modified after instantiation, throw
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			
			return (current != null);
		}

		/**
		 * Get the next element in the list
		 * @return the next element in the list
		 * @throws ConcurrentModificationException if the collection has been modified
		 */
		@Override
		public T next() {
			
			// if the collection was modified after instantiation, throw
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			
			// if there's no more elements, throw
			if (current == null) {
				throw new NoSuchElementException();
			}
			
			T result = current.getElement();
			
			current = current.getNext();
			
			return result;


			
		}
		
	}

}
