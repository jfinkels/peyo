/**
 * SequenceTest.java
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
import java.util.Arrays;
import java.util.List;

import jmona.MappingException;
import jmona.functional.Range;

import org.apache.commons.lang3.StringUtils;
import org.biojava.bio.seq.ProteinTools;
import org.biojava.bio.symbol.IllegalSymbolException;
import org.biojava.bio.symbol.SymbolList;
import org.junit.Test;

import peyo.test.TestUtils;

/**
 * Test class for the {@link Sequence} class.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public class SequenceTest {

  /**
   * Test method for {@link peyo.Sequence#toOneLetterString(java.util.List)}.
   */
  @Test
  public void testToOneLetterString() {
    List<Residue> sequence = new ArrayList<Residue>();

    try {
      assertEquals("", Sequence.toOneLetterString(sequence));
    } catch (final MappingException exception) {
      TestUtils.fail(exception);
    }

    final List<ResidueType> types = Arrays.asList(ResidueType.ALANINE,
        ResidueType.ARGININE, ResidueType.ASPARAGINE);

    for (final ResidueType type : types) {
      sequence.add(new Residue(type));
    }

    final List<Character> chars = Arrays.asList(
        ResidueType.ALANINE.oneLetterAbbreviation(),
        ResidueType.ARGININE.oneLetterAbbreviation(),
        ResidueType.ASPARAGINE.oneLetterAbbreviation());

    try {
      assertEquals(StringUtils.join(chars, ""),
          Sequence.toOneLetterString(sequence));
    } catch (final MappingException exception) {
      TestUtils.fail(exception);
    }

  }


  /**
   * Test method for {@link peyo.Sequence#fromOneLetterString(String)}.
   */
  @Test
  public void testFromOneLetterString() {
    final String string = "ARN";
    final List<Residue> sequence = Sequence.fromOneLetterString(string);
    assertEquals(3, sequence.size());
    
    assertEquals(ResidueType.ALANINE, sequence.get(0).type());
    assertEquals(ResidueType.ARGININE, sequence.get(1).type());
    assertEquals(ResidueType.ASPARAGINE, sequence.get(2).type());

  }

  /**
   * Test method for {@link peyo.Sequence#toThreeLetterString(java.util.List)}.
   */
  @Test
  public void testToThreeLetterString() {
    List<Residue> sequence = new ArrayList<Residue>();

    try {
      assertEquals("", Sequence.toThreeLetterString(sequence));
    } catch (final MappingException exception) {
      TestUtils.fail(exception);
    }

    final List<ResidueType> types = Arrays.asList(ResidueType.ALANINE,
        ResidueType.ARGININE, ResidueType.ASPARAGINE);

    for (final ResidueType type : types) {
      sequence.add(new Residue(type));
    }

    final List<String> strings = Arrays.asList(
        ResidueType.ALANINE.threeLetterAbbreviation(),
        ResidueType.ARGININE.threeLetterAbbreviation(),
        ResidueType.ASPARAGINE.threeLetterAbbreviation());

    try {
      assertEquals(StringUtils.join(strings, ""),
          Sequence.toThreeLetterString(sequence));
    } catch (final MappingException exception) {
      TestUtils.fail(exception);
    }

  }

  /**
   * Test method for {@link peyo.Sequence#toSymbolList(java.util.List)}.
   */
  @Test
  public void testToSymbolList() {
    List<Residue> sequence = new ArrayList<Residue>();

    try {
      assertEquals(0, Sequence.toSymbolList(sequence).length());
    } catch (final MappingException exception) {
      TestUtils.fail(exception);
    } catch (final IllegalSymbolException exception) {
      TestUtils.fail(exception);
    }

    final List<ResidueType> types = Arrays.asList(ResidueType.ALANINE,
        ResidueType.ARGININE, ResidueType.ASPARAGINE);

    for (final ResidueType type : types) {
      sequence.add(new Residue(type));
    }

    // A - Alanine, R - Arginine, N - Asparagine
    final String chain = "ARN";

    SymbolList expectedList = null;
    try {
      expectedList = ProteinTools.createProtein(chain);
    } catch (final IllegalSymbolException exception) {
      TestUtils.fail(exception);
    }

    SymbolList list = null;
    try {
      list = Sequence.toSymbolList(sequence);
    } catch (final IllegalSymbolException exception) {
      TestUtils.fail(exception);
    } catch (final MappingException exception) {
      TestUtils.fail(exception);
    }

    // BioJava uses 1-indexed lists
    for (final int i : new Range(1, sequence.size() + 1)) {
      assertEquals(expectedList.symbolAt(i), list.symbolAt(i));
    }
  }
}
