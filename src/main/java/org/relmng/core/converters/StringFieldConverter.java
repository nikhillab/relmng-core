/**
 * 
 */
package org.relmng.core.converters;

import org.relmng.core.crypto.RelMngEncryption;

import jakarta.persistence.Converter;

/**
 * 
 */
@Converter
public final class StringFieldConverter extends AbstractFieldConverter<String, String> {

	/**
	 * @param encryption
	 */
	public StringFieldConverter(RelMngEncryption encryption) {
		super(encryption);
	}

	@Override
	public String convertToDatabaseColumn(String attribute) {
		return super.getEncryption().encrypt(attribute);
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		return super.getEncryption().decrypt(dbData);
	}

}
