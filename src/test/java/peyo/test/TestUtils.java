/**
 * TreeUtils.java
 * 
 * Copyright 2010 Jeffrey Finkelstein
 * 
 * This file is part of peyo.
 * 
 * peyo is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * peyo is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * peyo. If not, see <http://www.gnu.org/licenses/>.
 */
package peyo.test;

/**
 * Utilities for testing, including a method which fails a test after
 * outputting an Exception's message.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public class TestUtils {
  /**
   * Print the stack trace of the specified exception and fail the test.
   * 
   * @param exception
   *          The exception which caused the test failure.
   */
  public static synchronized void fail(final Throwable exception) {
    exception.printStackTrace(System.err);
    org.junit.Assert.fail(exception.getMessage());
  }

  /**
   * Fail with the message that an Exception should have been thrown on the
   * previous line.
   */
  public static void shouldHaveThrownException() {
    org.junit.Assert
        .fail("Exception should have been thrown on previous line.");
  }

  /** Instantiation disallowed except by subclasses. */
  protected TestUtils() {
    // intentionally unimplemented
  }
}
