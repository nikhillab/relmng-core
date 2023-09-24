/**
 * 
 */
package org.relmng.core.file;

import java.io.IOException;
import java.nio.file.Path;

import org.relmng.core.file.manager.LocalFileManager;

/**
 * @author nikhil
 */
public interface RelMngFileManager {
	public Path write(String filePath, byte[] content) throws IOException;

	public Path write(String filePath, String content) throws IOException;

	public String read(String filePath) throws IOException;

	public boolean delete(String filePath) throws IOException;
	
	public boolean exist(String filePath) throws IOException;

	public static RelMngFileManager getFileManager(RelMngFileManagerType type) {
		return switch (type) {
		case LOCAL -> new LocalFileManager();
		default -> throw new IllegalArgumentException("Unexpected value: " + type);
		};
	}
}
