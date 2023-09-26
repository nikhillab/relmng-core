/**
 * 
 */
package org.relmng.core.repository;

import java.util.Optional;

import org.relmng.core.model.GridDetailsConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nikhil
 */
public interface GridDetailsConfigRepository extends JpaRepository<GridDetailsConfig, Long> {

	public Optional<GridDetailsConfig> findByComponentName(String componentName);
}
