/**
 * 
 */
package org.relmng.core.repository;

import org.relmng.core.model.EnvironmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nikhil
 */
public interface EnvironmentDetailRepository extends JpaRepository<EnvironmentDetails, Long> {

}
