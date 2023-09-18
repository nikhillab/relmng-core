package org.relmng.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "environment_details")
public class EnvironmentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long environmentId;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "aes_config_id")
	private long aesConfig;

	boolean isActive;

	/**
	 * @return the environmentId
	 */
	public long getEnvironmentId() {
		return environmentId;
	}

	/**
	 * @param environmentId the environmentId to set
	 */
	public void setEnvironmentId(long environmentId) {
		this.environmentId = environmentId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * @return the aesConfig
	 */
	public long getAesConfig() {
		return aesConfig;
	}

	/**
	 * @param aesConfig the aesConfig to set
	 */
	public void setAesConfig(long aesConfig) {
		this.aesConfig = aesConfig;
	}

}
