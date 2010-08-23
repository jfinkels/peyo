/**
 * Hmmer2ParserTest.java
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
package peyo;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import peyo.test.TestUtils;

/**
 * Test class for the {@link Hmmer2Parser} class.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public class Hmmer2ParserTest {

  /** The location of the example HMMER version 2 hidden Markov model file. */
  public static final String TESTFILE = "src/test/resources/peyo/example.hmm";

  /**
   * Test method for {@link peyo.Hmmer2Parser#parse(java.lang.String)}.
   */
  @Test
  public void testParseString() {
    HiddenMarkovModel model = null;
    try {
      model = Hmmer2Parser.parse(TESTFILE);

    } catch (final FileNotFoundException exception) {
      TestUtils.fail(exception);
    } catch (final IOException exception) {
      TestUtils.fail(exception);
    }
    
    assertEquals(201, model.length());
  }

  /**
   * Test method for {@link peyo.Hmmer2Parser#parse(java.io.File)}.
   */
  @Test
  public void testParseFile() {
    HiddenMarkovModel model = null;
    try {
      model = Hmmer2Parser.parse(new File(TESTFILE));

    } catch (final FileNotFoundException exception) {
      TestUtils.fail(exception);
    } catch (final IOException exception) {
      TestUtils.fail(exception);
    }
    
    assertEquals(201, model.length());
  }

}
