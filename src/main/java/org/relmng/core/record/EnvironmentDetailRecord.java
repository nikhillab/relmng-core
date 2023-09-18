package org.relmng.core.record;

public record EnvironmentDetailRecord(Long environmentId, String name, long aesConfig, boolean isActive) {
}