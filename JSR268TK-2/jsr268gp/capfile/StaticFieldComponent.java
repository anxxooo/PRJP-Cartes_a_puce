package jsr268gp.capfile;

/*
 * Copyright (c) 2006 Mesure Project
 * 
 * This software is a computer program whose purpose is to measure 
 * the performances of Java Card platforms.
 *
 * This software is governed by the CeCILL license under French law and
 * abiding by the rules of distribution of free software.  You can  use, 
 * modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info". 
 * 
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability. 
 * 
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or 
 * data to be ensured and,  more generally, to use and operate it in the 
 * same conditions as regards security. 
 * 
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 */

/*
 * $HeadURL: svn+ssh://jcordry@scm.gforge.inria.fr/svn/mesureprv/HEAD/src/lib/capfile/StaticFieldComponent.java $
 * Created: 1 septembre 2006
 * Author: TL 
 * $LastChangedRevision: 28 $
 * $LastChangedDate: 2006-09-13 13:44:36 +0000 (mer., 13 sept. 2006) $
 * $LastChangedBy: cpascal $
 */

import java.io.IOException;
import java.io.DataInputStream;

/**
 * A Static Field Component, as illustrated in Java Card platform Virtual 
 * Machine specification.
 */
public class StaticFieldComponent extends Component {
  
  /** 
   * Number of bytes required to represent the static fields
   * defined in this package, excluding final static fields of
   * primitive types. 
   **/
  private int imageSize;

  /**
   * Returns the image size.
   * 
   * @return the image size.
   */
  public int getImageSize() {
    return imageSize;
  }

  /**
   * Reads static field component from input stream.
   *
   * @param in input stream to read from.
   * @exception <tt>CAPException</tt> for any problem while reading the stream.
   **/
  public Component parse(DataInputStream in) throws CAPException
  {
	try {
      imageSize = in.readUnsignedShort();
	} catch (IOException e) {
	  throw new CAPException(e);
	}
    return this;
  }
}
