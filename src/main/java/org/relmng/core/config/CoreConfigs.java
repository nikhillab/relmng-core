/**
 * 
 */
package org.relmng.core.config;

import org.relmng.core.file.RelMngFileManager;
import org.relmng.core.file.RelMngFileManagerType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 */
@Configuration
@ComponentScan(basePackages = { "${packages.component}" })
public class CoreConfigs {
	@Bean
	public RelMngFileManager relMngFileManager(@Value("${env.type}") String type) {
		return RelMngFileManager.getFileManager(RelMngFileManagerType.valueOf(type));
	}
}
