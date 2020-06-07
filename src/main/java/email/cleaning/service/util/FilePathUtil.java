package email.cleaning.service.util;

import java.net.URISyntaxException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePathUtil {

	public Path getFilePath(String fileName) {
		Path path = null;
		try {
			path = Paths.get(fileName);
		} catch (InvalidPathException e) {
			e.printStackTrace();
		}
		
		return path;
	}

	public Path getFilePathFromResources(String fileName) {
		Path path = null;
		try {
			path = Paths.get(getClass().getClassLoader()
				      .getResource(fileName).toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} 
		
		return path;
	}
}
