/**
 * ProteinEvolutionTester.java
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

import jmona.CompletionCondition;
import jmona.CompletionException;
import jmona.DeepCopyableList;
import jmona.EvolutionContext;
import jmona.EvolutionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import peyo.test.TestUtils;

/**
 * Test class for the protein alignment evolution.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ProteinEvolutionTest {

  /** The completion condition which determines when the evolution should end. */
  @Autowired
  private CompletionCondition<DeepCopyableList<Residue>> condition = null;

  /** The context in which the evolution runs. */
  @Autowired
  private EvolutionContext<DeepCopyableList<Residue>> context = null;
  
  /** Test class for the protein alignment evolution. */
  @Test
  public void testEvolution() {
    try {
      while (!this.condition.execute(this.context)) {
        this.context.stepGeneration();
      }
    } catch (final CompletionException exception) {
      TestUtils.fail(exception);
    } catch (final EvolutionException exception) {
      TestUtils.fail(exception);
    }
  }
}
