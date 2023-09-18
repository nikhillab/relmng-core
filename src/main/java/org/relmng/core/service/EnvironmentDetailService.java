/**
 * 
 */
package org.relmng.core.service;

import org.relmng.core.mapper.EnvironmentDetailMapper;
import org.relmng.core.record.EnvironmentDetailRecord;
import org.relmng.core.repository.EnvironmentDetailRepository;
import org.springframework.stereotype.Service;

/**
 * 
 */
@Service
public class EnvironmentDetailService {

	private final EnvironmentDetailRepository environmentDetailsRepository;

	/**
	 * @param environmentDetailsRepository
	 */
	public EnvironmentDetailService(EnvironmentDetailRepository environmentDetailsRepository) {
		this.environmentDetailsRepository = environmentDetailsRepository;
	}

	public EnvironmentDetailRecord save(EnvironmentDetailRecord environmentDetailRecord) {
		var environmentDetails = EnvironmentDetailMapper.mapRecordToEnvironmentDetails(environmentDetailRecord);
		environmentDetails = environmentDetailsRepository.save(environmentDetails);
		return EnvironmentDetailMapper.mapToEnvironmentDetailRecord(environmentDetails);
	}

}
