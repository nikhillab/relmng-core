/**
 * 
 */
package org.relmng.core.file.manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.relmng.core.file.RelMngFileManager;

/**
 * 
 */
public class LocalFileManager implements RelMngFileManager {

	public Path write(String filePath, byte[] content) throws IOException {
		Path path = Paths.get(filePath);
		return Files.write(path, content, StandardOpenOption.CREATE);

	}

	public Path write(String filePath, String content) throws IOException {
		return write(filePath, content.getBytes());
	}

	public String read(String filePath) throws IOException {
		var path = Paths.get(filePath);
		if (path.toFile().exists())
			return Files.readString(path);
		return "";
	}

}
