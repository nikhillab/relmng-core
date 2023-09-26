/**
 * 
 */
package org.relmng.core.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author nikhil
 */
@Entity
@Table(name = "grid_details_config")
public class GridDetailsConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gridId;
	private String componentName;
	private Integer pageSize = 5;
	private Integer sizeOptions = 5;
	private boolean isActive;
	@OneToMany(mappedBy = "gridId", fetch = FetchType.LAZY)
	private Set<MapGridColumns> gridColumns;

	/**
	 * @return the gridId
	 */
	public Long getGridId() {
		return gridId;
	}

	/**
	 * @param gridId the gridId to set
	 */
	public void setGridId(Long gridId) {
		this.gridId = gridId;
	}

	/**
	 * @return the componentName
	 */
	public String getComponentName() {
		return componentName;
	}

	/**
	 * @param componentName the componentName to set
	 */
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the sizeOptions
	 */
	public Integer getSizeOptions() {
		return sizeOptions;
	}

	/**
	 * @param sizeOptions the sizeOptions to set
	 */
	public void setSizeOptions(Integer sizeOptions) {
		this.sizeOptions = sizeOptions;
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
	 * @return the gridColumns
	 */
	public Set<MapGridColumns> getGridColumns() {
		return gridColumns;
	}

	/**
	 * @param gridColumns the gridColumns to set
	 */
	public void setGridColumns(Set<MapGridColumns> gridColumns) {
		this.gridColumns = gridColumns;
	}

}
