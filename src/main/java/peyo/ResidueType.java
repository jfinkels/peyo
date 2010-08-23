/**
 * ResidueType.java
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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * A type of a residue in a protein or a peptide chain.
 * 
 * For more information on standard three-letter and one-letter abbreviations
 * for amino acids, see <a href=
 * "http://en.wikipedia.org/wiki/Amino_acid#Table_of_standard_amino_acid_abbreviations_and_properties"
 * >the Wikipedia article on amino acids</a>.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public enum ResidueType {
  ALANINE("Ala", 'A'), ARGININE("Arg", 'R'), ASPARAGINE("Asn", 'N'), ASPARTIC_ACID(
      "Asp", 'D'), CYSTEINE("Cys", 'C'), GLUTAMIC_ACID("Glu", 'E'), GLUTAMINE(
      "Gln", 'Q'), GLYCINE("Gly", 'G'), HISTIDINE("His", 'H'), ISOLEUCINE(
      "Ile", 'I'), LEUCINE("Leu", 'L'), LYSINE("Lys", 'K'), METHIONINE("Mer",
      'M'), PHENYLALANINE("Phe", 'F'), PROLINE("Pro", 'P'), SERINE("Ser", 'S'), THREONINE(
      "Thr", 'T'), TRYPTOPHAN("Trp", 'W'), TYROSINE("Tyr", 'Y'), VALINE("Val",
      'V'),

  SELENOCYSTEINE("SEC", 'U'), PYRROLYSINE("PYL", 'O'),

  /** A placeholder for either asparagine or aspartic acid. */
  ASPAR_("Asx", 'B'),
  /** A placeholder for either glutamine or glutamic acid. */
  GLUTAM_("Glx", 'Z'),
  /** A placeholder for either leucine or isoleucine. */
  _LEUCINE("Xle", 'J'),
  /** A placeholder for an unknown or otherwise unspecified residue. */
  UNKNOWN("Xaa", 'X');

  /**
   * An unmodifiable view on a collection (backed by a HashSet) which contains
   * each of the proteinogenic residue types.
   */
  public static final Collection<ResidueType> PROTEINOGENIC_RESIDUE_TYPES = Collections
      .unmodifiableSet(new HashSet<ResidueType>(Arrays.asList(ALANINE,
          ARGININE, ASPARAGINE, ASPARTIC_ACID, CYSTEINE, GLUTAMIC_ACID,
          GLUTAMINE, GLYCINE, HISTIDINE, ISOLEUCINE, LEUCINE, LYSINE,
          METHIONINE, PHENYLALANINE, PROLINE, SERINE, THREONINE, TRYPTOPHAN,
          TYROSINE, VALINE)));

  /** The standard three-letter abbreviation of this residue type. */
  private final String threeLetterAbbreviation;
  /** The standard one-letter abbreviation of this residue type. */
  private final char oneLetterAbbreviation;

  /**
   * Instantiates this type of Residue with the specified three-letter and
   * one-letter abbreviations (they should both match the standard known
   * abbreviations).
   * 
   * @param threeLetterAbbreviation
   *          The three-letter abbreviation of this type of Residue.
   * @param oneLetterAbbreviation
   *          The one-letter abbreviation of this type of Residue.
   */
  private ResidueType(final String threeLetterAbbreviation,
      final char oneLetterAbbreviation) {
    this.threeLetterAbbreviation = threeLetterAbbreviation;
    this.oneLetterAbbreviation = oneLetterAbbreviation;
  }

  /**
   * Gets the three-letter abbreviation of this Residue.
   * 
   * @return The three-letter abbreviation of this Residue.
   */
  public String threeLetterAbbreviation() {
    return this.threeLetterAbbreviation;
  }

  /**
   * Gets the one-letter abbreviation of this Residue.
   * 
   * @return The one-letter abbreviation of this Residue.
   */
  public char oneLetterAbbreviation() {
    return this.oneLetterAbbreviation;
  }

  /**
   * Returns the Residue whose amino acid type is represented by the specified
   * character.
   * 
   * @param character
   *          The character representing a type of amino acid.
   * @return A Residue whose amino acid type is represented by the specified
   *         character.
   */
  public static ResidueType fromChar(final char character) {
    ResidueType type = null;
    switch (character) {
    case 'A':
      type = ResidueType.ALANINE;
      break;
    case 'B':
      type = ResidueType.ASPAR_;
      break;
    case 'C':
      type = ResidueType.CYSTEINE;
      break;
    case 'D':
      type = ResidueType.ASPARTIC_ACID;
      break;
    case 'E':
      type = ResidueType.GLUTAMIC_ACID;
      break;
    case 'F':
      type = ResidueType.PHENYLALANINE;
      break;
    case 'G':
      type = ResidueType.GLYCINE;
      break;
    case 'H':
      type = ResidueType.HISTIDINE;
      break;
    case 'I':
      type = ResidueType.ISOLEUCINE;
      break;
    case 'J':
      type = ResidueType._LEUCINE;
      break;
    case 'K':
      type = ResidueType.LYSINE;
      break;
    case 'L':
      type = ResidueType.LEUCINE;
      break;
    case 'M':
      type = ResidueType.METHIONINE;
      break;
    case 'N':
      type = ResidueType.ASPARAGINE;
      break;
    case 'O':
      type = ResidueType.PYRROLYSINE;
      break;
    case 'P':
      type = ResidueType.PROLINE;
      break;
    case 'Q':
      type = ResidueType.GLUTAMINE;
      break;
    case 'R':
      type = ResidueType.ARGININE;
      break;
    case 'S':
      type = ResidueType.SERINE;
      break;
    case 'T':
      type = ResidueType.THREONINE;
      break;
    case 'U':
      type = ResidueType.SELENOCYSTEINE;
      break;
    case 'V':
      type = ResidueType.VALINE;
      break;
    case 'W':
      type = ResidueType.TRYPTOPHAN;
      break;
    case 'X':
      type = ResidueType.UNKNOWN;
      break;
    case 'Y':
      type = ResidueType.TYROSINE;
      break;
    case 'Z':
      type = ResidueType.GLUTAM_;
    }

    return type;
  }
}
