package org.relmng.core.mapper;

import org.relmng.core.model.EnvironmentDetails;
import org.relmng.core.record.EnvironmentDetailsRecord;

public class EnvironmentDetailsMapper {
	public static EnvironmentDetailsRecord mapToEnvironmentDetailsRecord(EnvironmentDetails environmentDetails) {
		return new EnvironmentDetailsRecord(environmentDetails.getEnvironmentId(), environmentDetails.getName(),
				environmentDetails.isActive());
	}

	public static EnvironmentDetails mapRecordToEnvironmentDetails(EnvironmentDetailsRecord environmentDetailsRecord) {
		EnvironmentDetails environmentDetails = new EnvironmentDetails();
		environmentDetails.setName(environmentDetailsRecord.name());
		environmentDetails.setEnvironmentId(environmentDetailsRecord.environmentId());
		environmentDetails.setActive(environmentDetailsRecord.isActive());
		return environmentDetails;
	}
}