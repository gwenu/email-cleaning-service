package email.cleaning.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import email.cleaning.service.util.FilePathUtil;

public class TextSourceUtil {
	
	public static List<String> getLinesFromFile(String fileName) {
		TextSource source = new PlainTextSource();
		Path filePath = new FilePathUtil().getFilePathFromResources(fileName);
		return source.getLines(filePath);
	}

	public static String getLinesFromFileAsString(String fileName) throws IOException {
		Path filePath = new FilePathUtil().getFilePathFromResources(fileName);
		return new String (Files.readAllBytes(filePath));
	}
}
