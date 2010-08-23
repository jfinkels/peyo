/**
 * ResidueFactoryTester.java
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

import jmona.MappingException;
import jmona.functional.Functional;
import jmona.functional.Range;
import jmona.impl.ListUtils;

import org.junit.Test;

import peyo.test.TestUtils;

/**
 * Test class for the {@link ResidueFactory} class.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public class ResidueFactoryTest {

  /** The number of residues to create. */
  public static final int NUM_RESIDUES = 100000;

  /**
   * Test method for {@link peyo.ResidueFactory#createObject()}.
   */
  @Test
  public void testCreateObject() {
    final ResidueFactory factory = new ResidueFactory();
    final List<Residue> residues = new ArrayList<Residue>();
    for (final int i : new Range(NUM_RESIDUES)) {
      residues.add(factory.createObject());
    }

    Map<ResidueType, Integer> counts = null;
    try {
      counts = ListUtils.count(Functional
          .map(ToResidueType.INSTANCE, residues));
    } catch (final MappingException exception) {
      TestUtils.fail(exception);
    }

    assertEquals(ResidueType.PROTEINOGENIC_RESIDUE_TYPES, counts.keySet());

    final int expected = (int) ((double) NUM_RESIDUES / ResidueType.PROTEINOGENIC_RESIDUE_TYPES
        .size());

    final double delta = expected * 0.1;

    for (final int count : counts.values()) {
      assertEquals(expected, count, delta);
    }
  }

}
