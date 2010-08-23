/**
 * HiddenMarkovModel.java
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

/**
 * A hidden Markov model.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public class HiddenMarkovModel {

  /** The length (that is, the number of match states) in this model. */
  private int length = 0;

  /**
   * Sets the length (that is, the number of match states) of this model.
   * 
   * @param newLength
   *          The length (that is, the number of match states) of this model.
   */
  void setLength(final int newLength) {
    this.length = newLength;
  }

  /**
   * Gets the length (that is, the number of match states) of this model.
   * 
   * @return The length (that is, the number of match states) of this model.
   */
  public int length() {
    return this.length;
  }
}
