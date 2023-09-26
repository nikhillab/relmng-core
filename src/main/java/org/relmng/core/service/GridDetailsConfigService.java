/**
 * 
 */
package org.relmng.core.service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.relmng.core.mapper.GridDetailsConfigMapper;
import org.relmng.core.record.GridRecord;
import org.relmng.core.repository.GridDetailsConfigRepository;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

/**
 * 
 */
@Service
public class GridDetailsConfigService {

	private final GridDetailsConfigRepository gridDetailsConfigRepository;

	private final Map<String, GridRecord> gridCache = new ConcurrentHashMap<>();

	/**
	 * @param gridDetailsConfigRepository
	 */
	public GridDetailsConfigService(GridDetailsConfigRepository gridDetailsConfigRepository) {
		this.gridDetailsConfigRepository = gridDetailsConfigRepository;
	}

	@PostConstruct
	public void reloadGridCache() {
		var gridRecordRecord = GridDetailsConfigMapper.mapToGridRecordRecord(gridDetailsConfigRepository.findAll());
		gridRecordRecord.forEach(grid -> gridCache.put(grid.componentName(), grid));
	}

	public GridRecord getGridByComponentName(String componentName) {
		if (!gridCache.containsKey(componentName)) {
			var result = gridDetailsConfigRepository.findByComponentName(componentName);
			if (result.isPresent()) {
				gridCache.put(componentName, GridDetailsConfigMapper.mapToGridRecordRecord(result.get()));
			}
		}
		return gridCache.get(componentName);
	}

	public Collection<GridRecord> getGrids() {
		return gridCache.values();
	}

}
