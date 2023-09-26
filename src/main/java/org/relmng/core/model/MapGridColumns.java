/**
 * 
 */
package org.relmng.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author nikhil
 */

@Entity
@Table(name = "map_grid_columns")
public class MapGridColumns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gridColumnId;
	private String field;
	private String headerName;
	private String width;
	private Long gridId;
	private boolean isActive;

	/**
	 * @return the gridColumnId
	 */
	public Long getGridColumnId() {
		return gridColumnId;
	}

	/**
	 * @param gridColumnId the gridColumnId to set
	 */
	public void setGridColumnId(Long gridColumnId) {
		this.gridColumnId = gridColumnId;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return the headerName
	 */
	public String getHeaderName() {
		return headerName;
	}

	/**
	 * @param headerName the headerName to set
	 */
	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}

	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}

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
