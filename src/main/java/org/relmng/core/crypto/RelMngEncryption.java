/**
 * 
 */
package org.relmng.core.crypto;

/**
 * 
 */
public interface RelMngEncryption {
	public byte[] encrypt(byte[] content);

	public byte[] decrypt(byte[] content);

	public String encrypt(String content);

	public String decrypt(String content);
}
