/**
 * 
 */
package org.relmng.core.mapper;

import org.relmng.core.model.RelMngAESConfig;
import org.relmng.core.record.RelMngAESConfigRecord;

/**
 * 
 */
public class RelMngAESConfigMapper {
	public static RelMngAESConfigRecord mapToRelMngAESConfigRecord(RelMngAESConfig aesConfig) {
		return new RelMngAESConfigRecord(aesConfig.getPkId(), aesConfig.getType(), aesConfig.getBits(),
				aesConfig.getSecretKey(), aesConfig.isActive());
	}

	public static RelMngAESConfig mapRecordToRelMngAESConfig(RelMngAESConfigRecord aesConfigRecord) {
		RelMngAESConfig aesConfig = new RelMngAESConfig();
		aesConfig.setPkId(aesConfigRecord.pkId());
		aesConfig.setType(aesConfigRecord.type());
		aesConfig.setBits(aesConfigRecord.bits());
		aesConfig.setSecretKey(aesConfigRecord.secretKey());
		aesConfig.setActive(aesConfigRecord.isActive());
		return aesConfig;
	}
}
