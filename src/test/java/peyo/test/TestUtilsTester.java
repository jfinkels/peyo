/**
 * TestUtilsTester.java
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

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for the testing utility class.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public class TestUtilsTester {

  /**
   * Test method for {@link peyo.test.TestUtils#fail(java.lang.Throwable)}.
   */
  @Test
  public void testFail() {
    try {
      TestUtils.fail(new Exception());
    } catch (final AssertionError error) {
      assertTrue(error instanceof AssertionError);
    }
  }

  /** Test method for {@link peyo.test.TestUtils#shouldHaveThrownException()}. */
  @Test
  public void testShouldHaveThrownException() {
    try {
      TestUtils.shouldHaveThrownException();
    } catch (final AssertionError error) {
      assertTrue(error instanceof AssertionError);
    }
  }

}
