/**
 * 
 */
package org.relmng.core.repository;

import org.relmng.core.model.RelMngAESConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 */
public interface RelMngAESConfigRepository extends JpaRepository<RelMngAESConfig, Long> {

	/**
	 * @param location
	 * @return RelMngAESConfig
	 */
	public abstract RelMngAESConfig findBySecretKey(String location);

}
