/**
 * 
 */
package org.relmng.core.crypto;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.relmng.core.file.RelMngFileManager;
import org.relmng.core.record.RelMngAESConfigRecord;
import org.springframework.core.env.Environment;

/**
 * 
 */
public class RelMngSecretKeyGenerator {

	private final Environment environment;
	private final RelMngFileManager relMngFileManager;

	/**
	 * @param environment
	 * @param relMngFileManager
	 */
	public RelMngSecretKeyGenerator(Environment environment, RelMngFileManager relMngFileManager) {
		this.environment = environment;
		this.relMngFileManager = relMngFileManager;
	}

	/**
	 * @param path
	 * @return
	 */
	public RelMngAESConfigRecord generateMasterKey(String path) {
		try {
			var bits = environment.getRequiredProperty("crypto.key.bits", Integer.class);
			var type = environment.getRequiredProperty("crypto.key.type");
			var location = environment.getProperty("crypto.key.location");
			var masterFilePath = location + path;
			boolean exist = relMngFileManager.exist(masterFilePath);
			if (!exist) {
				var generateKeys = generateKeys(bits, type);
				relMngFileManager.write(masterFilePath,
						Base64.getEncoder().encodeToString(generateKeys.getEncoded()).getBytes());
			}

			return new RelMngAESConfigRecord(0l, type, bits, masterFilePath, exist);

		} catch (NoSuchAlgorithmException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param bits
	 * @param type
	 * @return SecretKey
	 * @throws NoSuchAlgorithmException
	 */
	private SecretKey generateKeys(int bits, String type) throws NoSuchAlgorithmException {
		var keyGenerator = KeyGenerator.getInstance(type);
		keyGenerator.init(bits);
		return keyGenerator.generateKey();
	}
}
