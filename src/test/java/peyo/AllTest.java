/**
 * AllTest.java
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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs all tests in this package.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
@RunWith(Suite.class)
@SuiteClasses({ DPCreationExceptionTest.class, HiddenMarkovModelTest.class,
    Hmmer2ParserTest.class, ProteinEvolutionTest.class,
    ProteinFitnessFunctionTest.class, ResidueFactoryTest.class,
    ResidueMutationFunctionTest.class, ResidueTest.class,
    ResidueTypeTest.class, SequenceTest.class,
    ToOneLetterAbbreviationTest.class, ToResidueTypeTest.class,
    ToThreeLetterAbbreviationTest.class })
public class AllTest {
  // intentionally unimplemented
}
