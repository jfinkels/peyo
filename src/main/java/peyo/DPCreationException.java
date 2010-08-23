/**
 * DPCreationException.java
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
 * This Exception is thrown when there is a problem creating a {@link DP}
 * instance from a given {@link MarkovModel} object.
 * 
 * @author Jeffrey Finkelstein
 * @since 0.1
 */
public class DPCreationException extends Exception {

  /** Default generated serial version UID. */
  private static final long serialVersionUID = -1932344069161736982L;

  /**
   * Instantiate this class by calling the default constructor of the
   * superclass.
   */
  public DPCreationException() {
    super();
  }

  /**
   * Instantiate this Exception with the specified human-readable message.
   * 
   * @param message
   *          A human-readable message explaining the problem.
   */
  public DPCreationException(final String message) {
    super(message);
  }

  /**
   * Instantiate this Exception with the specified human-readable message and
   * the specified cause.
   * 
   * @param message
   *          A human-readable message explaining the problem.
   * @param cause
   *          The cause of this Exception.
   */
  public DPCreationException(final String message, final Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiate this Exception with the specified cause.
   * 
   * @param cause
   *          The cause of this Exception.
   */
  public DPCreationException(final Throwable cause) {
    super(cause);
  }

}
