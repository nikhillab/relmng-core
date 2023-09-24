package org.relmng.core.model;

import java.util.Set;

import org.relmng.core.converters.StringFieldConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aes_config")
public class RelMngAESConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pkId;
	private String type;
	private int bits;

	@Convert(converter = StringFieldConverter.class)
	private String secretKey;
	@OneToMany(mappedBy = "aesConfig", fetch = FetchType.LAZY)
	private Set<EnvironmentDetails> environmentDetails;

	private boolean isActive;

	/**
	 * @return the pkId
	 */
	public long getPkId() {
		return pkId;
	}

	/**
	 * @param pkId the pkId to set
	 */
	public void setPkId(long pkId) {
		this.pkId = pkId;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the bits
	 */
	public int getBits() {
		return bits;
	}

	/**
	 * @param bits the bits to set
	 */
	public void setBits(int bits) {
		this.bits = bits;
	}

	/**
	 * @return the secretKey
	 */
	public String getSecretKey() {
		return secretKey;
	}

	/**
	 * @param secretKey the secretKey to set
	 */
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	/**
	 * @return the environmentDetails
	 */
	public Set<EnvironmentDetails> getEnvironmentDetails() {
		return environmentDetails;
	}

	/**
	 * @param environmentDetails the environmentDetails to set
	 */
	public void setEnvironmentDetails(Set<EnvironmentDetails> environmentDetails) {
		this.environmentDetails = environmentDetails;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
