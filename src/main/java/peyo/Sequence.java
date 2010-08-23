/**
 * Sequence.java
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

import java.util.ArrayList;
import java.util.List;

import jmona.MappingException;
import jmona.functional.Functional;

import org.apache.commons.lang3.StringUtils;
import org.biojava.bio.seq.ProteinTools;
import org.biojava.bio.symbol.IllegalSymbolException;
import org.biojava.bio.symbol.SymbolList;

/**
 * Provides conversions between Residue objects, Lists of Residue objects, and
 * Strings.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public class Sequence {

  /**
   * Converts the specified List of Residue objects to a String consisting of
   * the one letter abbreviations of each of the residues in order with no
   * spaces in between.
   * 
   * @param residues
   *          The List of Residue objects to convert.
   * @return A String containing the concatenation of each of the one letter
   *         abbreviations of the Residue objects in the specified List, in
   *         order.
   * @throws MappingException
   *           If there is a problem mapping a Residue object to a one letter
   *           abbreviation.
   */
  public static String toOneLetterString(final List<Residue> residues)
      throws MappingException {
    return StringUtils.join(
        Functional.map(ToOneLetterAbbreviation.INSTANCE, residues), "");
  }

  /**
   * Converts the specified List of Residue objects to a String consisting of
   * the three letter abbreviations of each of the residues in order with no
   * spaces in between.
   * 
   * @param residues
   *          The List of Residue objects to convert.
   * @return A String containing the concatenation of each of the three letter
   *         abbreviations of the Residue objects in the specified List, in
   *         order.
   * @throws MappingException
   *           If there is a problem mapping a Residue object to a three letter
   *           abbreviation.
   */
  public static String toThreeLetterString(final List<Residue> residues)
      throws MappingException {
    return StringUtils.join(
        Functional.map(ToThreeLetterAbbreviation.INSTANCE, residues), "");
  }

  /**
   * Converts the specified List of Residue objects to a SymbolList object.
   * 
   * @param residues
   *          The List of Residue objects to convert to a SymbolList object.
   * @return A SymbolList consisting of the Symbols of the specified List of
   *         Residues.
   * @throws IllegalSymbolException
   *           If the List of Residues produces an unknown symbol
   *           representation.
   * @throws MappingException
   *           If there is a problem mapping the List of residues to a String
   *           of one letter characters.
   */
  public static SymbolList toSymbolList(final List<Residue> residues)
      throws IllegalSymbolException, MappingException {
    return ProteinTools.createProtein(toOneLetterString(residues));
  }

  /**
   * Converts the specified sequence of characters representing amino acids to
   * a List of Residue objects.
   * 
   * @param string
   *          A sequence of characters representing amino acids.
   * @return A List of Residue objects, each of whose type is an amino acid
   *         represented by the corresponding character in the input string.
   */
  public static List<Residue> fromOneLetterString(final String string) {
    final List<Residue> result = new ArrayList<Residue>();
    for (int i = 0; i < string.length(); ++i) {
      result.add(Residue.fromChar(string.charAt(i)));
    }
    return result;
  }

}
