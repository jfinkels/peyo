/**
 * ResidueMutationFunctionTester.java
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jmona.Function;
import jmona.MappingException;
import jmona.functional.Functional;
import jmona.functional.Range;
import jmona.impl.ListUtils;

import org.junit.Test;

import peyo.test.TestUtils;

/**
 * Test class for the ResidueMutationFunction class
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public class ResidueMutationFunctionTest {

  /** The number of residues in the list to test. */
  public static final int NUM_RESIDUES = 10000;

  /**
   * A function which maps a Residue to its ResidueType.
   * 
   * @author Jeffrey Finkelstein
   * @since 0.1
   */
  private class ToResidueType implements Function<Residue, ResidueType> {
    /**
     * Instantiates this class.
     */
    public ToResidueType() {
      // intentionally unimplemented; provided to avoid synthetic accessor
      // emulation
    }

    /**
     * Maps the specified residue to its type.
     * 
     * @param residue
     *          The residue whose type to get.
     * @return The type of the specified residue.
     * @see peyo.Function#execute(java.lang.Object)
     */
    @Override
    public ResidueType execute(final Residue residue) {
      return residue.type();
    }
  }

  /**
   * Test method for {@link ResidueMutationFunction#mutate(Residue)} .
   */
  @Test
  public void testMutate() {
    final ResidueMutationFunction function = new ResidueMutationFunction();
    final List<Residue> residues = new ArrayList<Residue>();

    for (final int i : new Range(NUM_RESIDUES)) {
      residues.add(new Residue(ResidueType.ALANINE));
    }

    for (final Residue residue : residues) {
      function.mutate(residue);
    }

    Map<ResidueType, Integer> counts = null;
    try {
      counts = ListUtils.count(Functional.map(new ToResidueType(), residues));
    } catch (final MappingException exception) {
      TestUtils.fail(exception);
    }

    final int expectedCount = (int) (NUM_RESIDUES / (double) ResidueType.PROTEINOGENIC_RESIDUE_TYPES
        .size());
    final double delta = NUM_RESIDUES * 0.1;
    for (final int count : counts.values()) {
      assertEquals(expectedCount, count, delta);
    }
  }
}
