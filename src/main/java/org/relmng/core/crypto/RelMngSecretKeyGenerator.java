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
import org.relmng.core.service.RelMngAESConfigService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
public class RelMngSecretKeyGenerator {

	private final Environment environment;
	private final RelMngFileManager relMngFileManager;
	private final RelMngAESConfigService aesConfigService;

	/**
	 * @param environment
	 * @param relMngFileManager
	 */
	public RelMngSecretKeyGenerator(Environment environment, RelMngFileManager relMngFileManager,
			RelMngAESConfigService aesConfigService) {
		this.environment = environment;
		this.relMngFileManager = relMngFileManager;
		this.aesConfigService = aesConfigService;
//		generateMasterKey(environment.getRequiredProperty("crypto.key.bits", Integer.class),
//				environment.getRequiredProperty("crypto.key.type"), "RELMNG_MASTER.txt");
	}

	/**
	 * @param bits
	 * @param type
	 * @param path
	 * @return
	 */
	public RelMngAESConfigRecord generateMasterKey(int bits, String type, String path) {
		try {
			SecretKey generateKeys = generateKeys(bits, type);
			String location = environment.getProperty("crypto.key.location");
			relMngFileManager.write(location + path,
					Base64.getEncoder().encodeToString(generateKeys.getEncoded()).getBytes());

			// TBD: save in DB
			return aesConfigService.save(new RelMngAESConfigRecord(0l, type, bits, path, true));

		} catch (NoSuchAlgorithmException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param bits
	 * @param type
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private SecretKey generateKeys(int bits, String type) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(type);
		keyGenerator.init(bits);
		return keyGenerator.generateKey();
	}
}
