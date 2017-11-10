/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 3
 * Unit Test Classes
 */
package com.andrewasquith.comp2231.assignment3.tests;

/**
 * JUnit Test Suite Annotations
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Entry point class for the entire test suite
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  UnorderedArrayListTests.class,
  UnorderedLinkedListTests.class,
  LinkedListStackTests.class,
  ArrayListStackTests.class,
  LinkedListQueueTests.class,
  ArrayListQueueTests.class
})
public class AssignmentTestSuite {
  // used only as a holder for the above annotations
}