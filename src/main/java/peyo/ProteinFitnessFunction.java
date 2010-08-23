/**
 * ProteinFitnessFunction.java
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

import java.util.List;

import jmona.FitnessException;
import jmona.MappingException;
import jmona.PropertyNotSetException;
import jmona.impl.fitness.MaximizingFitnessFunction;

import org.apache.log4j.Logger;
import org.biojava.bio.BioException;
import org.biojava.bio.dp.DP;
import org.biojava.bio.dp.DPFactory;
import org.biojava.bio.dp.IllegalTransitionException;
import org.biojava.bio.dp.MarkovModel;
import org.biojava.bio.dp.ScoreType;
import org.biojava.bio.dp.StatePath;
import org.biojava.bio.symbol.IllegalAlphabetException;
import org.biojava.bio.symbol.IllegalSymbolException;
import org.biojava.bio.symbol.SymbolList;

/**
 * Scores protein chains based on a profile motif.
 * 
 * For more information on generating a score from a test sequence, see
 * BioJava. http://www.biojava.org/wiki/BioJava:CookBook:DP:HMM
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public class ProteinFitnessFunction extends
    MaximizingFitnessFunction<List<Residue>> {

  /** The Logger for this class. */
  private static final transient Logger LOG = Logger
      .getLogger(ProteinFitnessFunction.class);

  /**
   * The dynamic programming matrix with which to run the Viterbi algorithm to
   * compute a path through a Markov model.
   */
  private DP dynamicProgrammingMatrix = null;

  /**
   * @param maximumRawFitness
   */
  public ProteinFitnessFunction(double maximumRawFitness) {
    super(maximumRawFitness);
  }

  public void setHiddenMarkovModel(final MarkovModel newHiddenMarkovModel)
      throws DPCreationException {
    try {
      this.dynamicProgrammingMatrix = DPFactory.DEFAULT
          .createDP(newHiddenMarkovModel);
    } catch (final IllegalArgumentException exception) {
      throw new DPCreationException(exception);
    } catch (final BioException exception) {
      throw new DPCreationException(exception);
    }
  }

  /**
   * Returns the probability score of applying the specified sequence of
   * residues to
   * 
   * @see jmona.FitnessFunction#rawFitness(java.lang.Object)
   */
  @Override
  public double rawFitness(final List<Residue> individual)
      throws FitnessException {
    if (this.dynamicProgrammingMatrix == null) {
      throw new PropertyNotSetException(
          "Must set a hidden Markov model before running the rawFitness() method.");
    }

    // convert the list of residues to a SymbolList, which BioJava understands
    SymbolList sequence = null;
    try {
      sequence = Sequence.toSymbolList(individual);
    } catch (final IllegalSymbolException exception) {
      throw new FitnessException(
          "Unknown residue abbreviation in string representing residue sequence.",
          exception);
    } catch (final MappingException exception) {
      throw new FitnessException(
          "Failed to convert residue sequence to string.", exception);
    }

    // run the Viterbi algorithm to determine a how probable the specified
    // sequence of residues matches with the specified hidden Markov model
    StatePath path = null;
    try {
      path = this.dynamicProgrammingMatrix.viterbi(
          new SymbolList[] { sequence }, ScoreType.ODDS);
    } catch (final IllegalSymbolException exception) {
      throw new FitnessException("Failed to run the Viterbi algorithm.",
          exception);
    } catch (final IllegalArgumentException exception) {
      throw new FitnessException("Failed to run the Viterbi algorithm.",
          exception);
    } catch (final IllegalAlphabetException exception) {
      throw new FitnessException("Failed to run the Viterbi algorithm.",
          exception);
    } catch (final IllegalTransitionException exception) {
      throw new FitnessException("Failed to run the Viterbi algorithm.",
          exception);
    }

    return path.getScore();
  }
}
