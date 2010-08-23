/**
 * DistributionFactory.java
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

import jmona.Factory;
import jmona.functional.Range;
import jmona.random.RandomUtils;

/**
 * A factory which creates a probability distribution, provided as an array of
 * double values.
 * 
 * Users of this class must call the {@link #setLength(int)} method before
 * calling the {@link #createObject()} method; otherwise the array returned by
 * the {@link #createObject()} method will be of length 0.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public class DistributionFactory implements Factory<double[]> {

  /** The length of the probability distribution. */
  private int length = 0;

  /**
   * Sets the length of the array of {@code double}s to create.
   * 
   * @param newLength
   *          The length of the array of {@code double}s to create.
   */
  public void setLength(final int newLength) {
    this.length = newLength;
  }

  /**
   * Creates an array of {@code double}s of size specified by the
   * {@link #setLength(int)} method, initialized with random double values
   * between 0 and 1.
   * 
   * @return An array of doubles with random entries between 0 and 1 of length
   *         determined by the {@link #setLength(int)} method.
   * @see jmona.Factory#createObject()
   */
  @Override
  public double[] createObject() {
    final double[] result = new double[this.length];

    // TODO replace this with some logic which determines an appropriate
    // probability for mutation of each residue in the sequence
    for (final int i : new Range(this.length)) {
      result[i] = RandomUtils.nextDouble();
    }

    return result;
  }
}
