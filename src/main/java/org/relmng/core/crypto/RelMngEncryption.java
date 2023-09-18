/**
 * 
 */
package org.relmng.core.crypto;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 * 
 */
public interface RelMngEncryption {
	public byte[] encrypt(byte[] content) throws IllegalBlockSizeException, BadPaddingException;

	public byte[] decrypt(byte[] content) throws IllegalBlockSizeException, BadPaddingException;
}
