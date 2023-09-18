package org.relmng.core.mapper;

import org.relmng.core.model.EnvironmentDetails;
import org.relmng.core.record.EnvironmentDetailRecord;

public class EnvironmentDetailMapper {
	public static EnvironmentDetailRecord mapToEnvironmentDetailRecord(EnvironmentDetails environmentDetails) {
		return new EnvironmentDetailRecord(environmentDetails.getEnvironmentId(), environmentDetails.getName(),
				environmentDetails.getAesConfig(), environmentDetails.isActive());
	}

	public static EnvironmentDetails mapRecordToEnvironmentDetails(EnvironmentDetailRecord environmentDetailsRecord) {
		EnvironmentDetails environmentDetails = new EnvironmentDetails();
		environmentDetails.setName(environmentDetailsRecord.name());
		environmentDetails.setEnvironmentId(environmentDetailsRecord.environmentId());
		environmentDetails.setActive(environmentDetailsRecord.isActive());
		environmentDetails.setAesConfig(environmentDetailsRecord.aesConfig());
		return environmentDetails;
	}
}