/**
 * Residue.java
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

import jmona.DeepCopyable;

/**
 * An amino acid residue in a protein or peptide chain.
 * 
 * Though instances of this class are completely characterized by their type,
 * we need this wrapper class around the ResidueType enum so that elements of a
 * list of residues are mutable (specifically, they have a
 * {@link #setType(ResidueType)} method). We cannot just use a list of
 * ResidueType enums to represent the protein chain because then elements of
 * the list are immutable. We need the elements of the list to be mutable so
 * that we can use a jmona.impl.mutation.ElementwiseMutationFunction on them.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public class Residue implements DeepCopyable<Residue> {

  /** The type of this residue. */
  private ResidueType type = ResidueType.UNKNOWN;

  /**
   * Instantiates this residue with the specified type.
   * 
   * @param initialType
   *          The type of this residue.
   */
  public Residue(final ResidueType initialType) {
    this.type = initialType;
  }

  /**
   * Gets the type of this residue.
   * 
   * @return The type of this residue.
   */
  public ResidueType type() {
    return this.type;
  }

  /**
   * Sets the type of this residue.
   * 
   * @param newType
   *          The type of this residue.
   */
  public void setType(final ResidueType newType) {
    this.type = newType;
  }

  /**
   * {@inheritDoc}
   * 
   * @return {@inheritDoc}
   * @see peyo.DeepCopyable#deepCopy()
   */
  @Override
  public Residue deepCopy() {
    return new Residue(this.type);
  }

  /**
   * Returns a new Residue object whose ResidueType is specified by the given
   * single letter abbreviation of an amino acid.
   * 
   * @param character
   *          The single letter abbreviation of the ResidueType of this
   *          Residue.
   * @return A Residue whose ResidueType is specified by the given single
   *         letter abbreviation of an amino acid.
   */
  public static Residue fromChar(final char character) {
    return new Residue(ResidueType.fromChar(character));
  }
}
