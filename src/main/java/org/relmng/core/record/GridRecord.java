/**
 * 
 */
package org.relmng.core.record;

import java.util.List;

/**
 * @author nikhil
 */
public record GridRecord(Long gridId, String componentName, Integer pageSize, Integer sizeOptions,
		List<GridColumns> columns) {

}
