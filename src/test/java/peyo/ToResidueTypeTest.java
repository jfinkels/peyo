/**
 * ToResidueTypeTest.java
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

import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Test class for the {@link ToResidueType} class.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public class ToResidueTypeTest {

  /**
   * Test method for {@link peyo.ToResidueType#execute(peyo.Residue)}.
   */
  @Test
  public void testExecute() {
    for (final ResidueType type : ResidueType.PROTEINOGENIC_RESIDUE_TYPES) {
      assertSame(type, ToResidueType.INSTANCE.execute(new Residue(type)));
    }
  }

}
