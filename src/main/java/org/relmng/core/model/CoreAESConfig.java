package org.relmng.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aes_config")
public class CoreAESConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pkId;
}
