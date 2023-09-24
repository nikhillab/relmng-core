/**
 * 
 */
package org.relmng.core.converters;

import org.relmng.core.crypto.RelMngEncryption;

import jakarta.persistence.AttributeConverter;

/**
 * 
 */
public sealed abstract class AbstractFieldConverter<T, R> implements AttributeConverter<T, R>
		permits StringFieldConverter {

	private final RelMngEncryption encryption;

	public AbstractFieldConverter(RelMngEncryption encryption) {
		this.encryption = encryption;
	}

	/**
	 * @return the encryption
	 */
	public RelMngEncryption getEncryption() {
		return encryption;
	}

}
