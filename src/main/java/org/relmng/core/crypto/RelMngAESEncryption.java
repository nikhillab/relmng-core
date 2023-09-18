package org.relmng.core.crypto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class RelMngAESEncryption implements RelMngEncryption {

	private Cipher encryptionCipher;
	private Cipher decryptionCipher;
	private IvParameterSpec parameterSpec;

	/**
	 * @param secretKey
	 */
	public RelMngAESEncryption(SecretKey secretKey) {
		try {
			this.parameterSpec = new IvParameterSpec(new byte[16]);
			encryptionCipher = Cipher.getInstance("AES/CTR/NoPadding");
			encryptionCipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
			decryptionCipher = Cipher.getInstance("AES/CTR/NoPadding");
			decryptionCipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);

		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
				| InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
	}

	@Override
	public byte[] encrypt(byte[] content) throws IllegalBlockSizeException, BadPaddingException {
		byte[] encryptedMessageBytes = encryptionCipher.doFinal(content);
		String encryptedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);
		System.out.println("Encrypted message = " + encryptedMessage);
		return Base64.getEncoder().encodeToString(encryptedMessageBytes).getBytes(StandardCharsets.UTF_8);
	}

	@Override
	public byte[] decrypt(byte[] content) throws IllegalBlockSizeException, BadPaddingException {
		byte[] decode = Base64.getDecoder().decode(content);
		byte[] decryptedMessageBytes = decryptionCipher.doFinal(decode);
		String decryptedMessage = new String(decryptedMessageBytes);
		System.out.println("decrypted message =" + decryptedMessage);
		return decryptionCipher.doFinal(content);
	}

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, IOException {

		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(256);
		SecretKey secretKey = keyGenerator.generateKey();

		System.out.println(new String(secretKey.getEncoded()));
		String secretKeyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		System.out.println("generated key = " + secretKeyString);

		byte[] decode = Base64.getDecoder().decode(secretKeyString);
		System.out.println(new String(decode));

		Path path = Paths.get("key.txt");
		Files.write(path, secretKeyString.getBytes(), StandardOpenOption.CREATE);

		byte[] encoded = Files.readAllBytes(path);

		byte[] decode2 = Base64.getDecoder().decode(encoded);
		System.out.println(new String(decode2));

		SecretKey secretKey2 = new SecretKeySpec(decode2, "AES");

		System.out.println(new String(secretKey2.getEncoded()));

		// Encrypt Hello world message
		Cipher encryptionCipher = Cipher.getInstance("AES/CTR/NoPadding");
		IvParameterSpec parameterSpec = new IvParameterSpec(new byte[16]);
		encryptionCipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
		String message = "";
		byte[] encryptedMessageBytes = encryptionCipher.doFinal(message.getBytes());
		String encryptedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);
		System.out.println("Encrypted message = " + encryptedMessage);

		// Decrypt the encrypted message
		Cipher decryptionCipher = Cipher.getInstance("AES/CTR/NoPadding");
		decryptionCipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);
		byte[] decryptedMessageBytes = decryptionCipher.doFinal(encryptedMessageBytes);
		String decryptedMessage = new String(decryptedMessageBytes);
		System.out.println("decrypted message =" + decryptedMessage);

	}
}