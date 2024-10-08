/**
 * 
 */
package org.relmng.core.service;

import org.relmng.core.mapper.RelMngAESConfigMapper;
import org.relmng.core.record.RelMngAESConfigRecord;
import org.relmng.core.repository.RelMngAESConfigRepository;
import org.springframework.stereotype.Service;

/**
 * 
 */
@Service
public class RelMngAESConfigService {

	private final RelMngAESConfigRepository aesConfigRepository;

	/**
	 * @param aesConfigRepository
	 */
	public RelMngAESConfigService(RelMngAESConfigRepository aesConfigRepository) {
		this.aesConfigRepository = aesConfigRepository;
	}

	/**
	 * @param aesConfigRecord
	 * @return RelMngAESConfigRecord
	 */
	public RelMngAESConfigRecord save(RelMngAESConfigRecord aesConfigRecord) {
		var aesConfig = RelMngAESConfigMapper.mapRecordToRelMngAESConfig(aesConfigRecord);
		aesConfig = aesConfigRepository.save(aesConfig);
		return RelMngAESConfigMapper.mapToRelMngAESConfigRecord(aesConfig);
	}

	/**
	 * @param location
	 * @return RelMngAESConfigRecord
	 */
	public RelMngAESConfigRecord getAESConfigByLocation(String location) {
		var aesConfig = aesConfigRepository.findBySecretKey(location);
		return RelMngAESConfigMapper.mapToRelMngAESConfigRecord(aesConfig);
	}
}
