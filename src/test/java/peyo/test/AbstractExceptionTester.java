/**
 * AbstractExceptionTester.java
 * 
 * Copyright 2010 Jeffrey Finkelstein
 * 
 * This file is part of jmona.
 * 
 * jmona is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * jmona is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * jmona. If not, see <http://www.gnu.org/licenses/>.
 */
package peyo.test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;


/**
 * Base class for all Exception test classes.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.5
 */
public abstract class AbstractExceptionTester {

  /** The message to provide to the constructors of the Exceptions under test. */
  public static final String TEST_MESSAGE = "Hello, world!";
  /** The Throwable to provide to the constructors of the Exceptions under test. */
  public static final Throwable TEST_CAUSE = new Exception();
  /** The Exception instantiated using the constructor with no arguments. */
  private Exception exceptionNoArgs = null;
  /**
   * The Exception instantiated using the constructor with a single String
   * argument.
   */
  private Exception exceptionString = null;
  /**
   * The Exception instantiated using the constructor with a single Throwable
   * argument.
   */
  private Exception exceptionThrowable = null;
  /**
   * The Exception instantiated using the constructor with a String argument and
   * a Throwable argument.
   */
  private Exception exceptionStringThrowable = null;

  /** The class of the Exception to test. */
  private final Class<? extends Exception> exceptionClass;

  /**
   * Instantiates this test class for an Exception of the specified class.
   * 
   * @param clazz
   *          The class of the Exception to test.
   */
  public AbstractExceptionTester(final Class<? extends Exception> clazz) {
    this.exceptionClass = clazz;
  }

  /** Instantiate the Exception using each of the four constructors. */
  @Before
  public void setUp() {
    try {
      this.exceptionNoArgs = this.exceptionClass.getConstructor().newInstance();
      this.exceptionString = this.exceptionClass.getConstructor(String.class)
          .newInstance(TEST_MESSAGE);
      this.exceptionThrowable = this.exceptionClass.getConstructor(
          Throwable.class).newInstance(TEST_CAUSE);
      this.exceptionStringThrowable = this.exceptionClass.getConstructor(
          String.class, Throwable.class).newInstance(TEST_MESSAGE, TEST_CAUSE);
    } catch (final IllegalArgumentException exception) {
      TestUtils.fail(exception);
    } catch (final SecurityException exception) {
      TestUtils.fail(exception);
    } catch (final InstantiationException exception) {
      TestUtils.fail(exception);
    } catch (final IllegalAccessException exception) {
      TestUtils.fail(exception);
    } catch (final InvocationTargetException exception) {
      TestUtils.fail(exception);
    } catch (final NoSuchMethodException exception) {
      TestUtils.fail(exception);
    }
  }

  /** Test the Exception. */
  @Test
  public void testException() {
    try {
      throw this.exceptionNoArgs;
    } catch (final Exception exception) {
      assertTrue(exception.getClass().equals(this.exceptionClass));
    }

    try {
      throw this.exceptionString;
    } catch (final Exception exception) {
      assertTrue(exception.getClass().equals(this.exceptionClass));
      assertSame(TEST_MESSAGE, exception.getMessage());
    }

    try {
      throw this.exceptionThrowable;
    } catch (final Exception exception) {
      assertTrue(exception.getClass().equals(this.exceptionClass));
      assertSame(TEST_CAUSE, exception.getCause());
    }

    try {
      throw this.exceptionStringThrowable;
    } catch (final Exception exception) {
      assertTrue(exception.getClass().equals(this.exceptionClass));
      assertSame(TEST_MESSAGE, exception.getMessage());
      assertSame(TEST_CAUSE, exception.getCause());
    }
  }
}
