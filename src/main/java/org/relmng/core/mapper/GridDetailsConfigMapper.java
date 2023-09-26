/**
 * 
 */
package org.relmng.core.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.relmng.core.model.GridDetailsConfig;
import org.relmng.core.model.MapGridColumns;
import org.relmng.core.record.GridColumns;
import org.relmng.core.record.GridRecord;

/**
 * 
 */
public class GridDetailsConfigMapper {

	public static GridRecord mapToGridRecordRecord(GridDetailsConfig gridDetailsConfig) {
		Set<MapGridColumns> gridColumns = gridDetailsConfig.getGridColumns();
		var gridRecord = new GridRecord(gridDetailsConfig.getGridId(), gridDetailsConfig.getComponentName(),
				gridDetailsConfig.getPageSize(), gridDetailsConfig.getSizeOptions(),
				mapToGridColumnsRecoed(gridColumns));
		return gridRecord;
	}

	public static List<GridRecord> mapToGridRecordRecord(List<GridDetailsConfig> gridDetailsConfig) {
		return gridDetailsConfig.stream().parallel().map(GridDetailsConfigMapper::mapToGridRecordRecord).toList();
	}

	private static List<GridColumns> mapToGridColumnsRecoed(Set<MapGridColumns> gridColumns) {
		var gridColumnsList = new ArrayList<GridColumns>(gridColumns.size());
		for (var gridColumn : gridColumns) {
			gridColumnsList
					.add(new GridColumns(gridColumn.getField(), gridColumn.getHeaderName(), gridColumn.getWidth()));
		}
		return gridColumnsList;
	}

}
