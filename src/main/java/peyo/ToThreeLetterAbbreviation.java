/**
 * ToThreeLetterAbbreviation.java
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

import jmona.Function;

/**
 * Maps a Residue to its three letter abbreviation.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public class ToThreeLetterAbbreviation implements Function<Residue, String> {

  /** An instance of this class. */
  public static final ToThreeLetterAbbreviation INSTANCE = new ToThreeLetterAbbreviation();

  /**
   * Returns the three letter abbreviation of the specified Residue.
   * 
   * @return The three letter abbreviation of the specified Residue.
   * @see jmona.Function#execute(java.lang.Object)
   */
  @Override
  public String execute(final Residue residue) {
    return residue.type().threeLetterAbbreviation();
  }

}
