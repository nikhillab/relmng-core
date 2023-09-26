/**
 * 
 */
package org.relmng.core.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.relmng.core.crypto.RelMngAESEncryption;
import org.relmng.core.crypto.RelMngEncryption;
import org.relmng.core.crypto.RelMngSecretKeyGenerator;
import org.relmng.core.file.RelMngFileManager;
import org.relmng.core.file.RelMngFileManagerType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;

/**
 * 
 */
@Configuration
@ComponentScan(basePackages = { "${packages.component}" })
public class CoreConfiguration {

	/**
	 * 
	 */
	private static final String MASTER_KEY_FILE_NAME = "RELMNG_MASTER.txt";

	@Bean
	public RelMngFileManager relMngFileManager(@Value("${env.type}") String type) {
		return RelMngFileManager.getFileManager(RelMngFileManagerType.valueOf(type));
	}

	@Bean
	public RelMngSecretKeyGenerator relMngSecretKeyGenerator(Environment environment,
			RelMngFileManager relMngFileManager) {
		RelMngSecretKeyGenerator secretKeyGenerator = new RelMngSecretKeyGenerator(environment, relMngFileManager);
		secretKeyGenerator.generateMasterKey(MASTER_KEY_FILE_NAME);
		return secretKeyGenerator;
	}

	@Bean
	@DependsOn(value = { "relMngSecretKeyGenerator" })
	public SecretKey secretKey(@Value("${crypto.key.location}") String basePackage,
			@Value("${crypto.key.type}") String type) {
		try {
			Path file = Paths.get(basePackage + MASTER_KEY_FILE_NAME);
			if (file.toFile().exists()) {
				byte[] encoded = Files.readAllBytes(file);
				byte[] decode = Base64.getDecoder().decode(encoded);

				return new SecretKeySpec(decode, type);
			} else {
				throw new RuntimeException("Master key file does not exist");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Bean
	@DependsOn(value = { "secretKey" })
	public RelMngEncryption relMngEncryption(SecretKey secretKey) {
		return new RelMngAESEncryption(secretKey);
	}

}
