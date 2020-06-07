package email.cleaning.service.util;

import java.util.List;

import email.cleaning.service.PlainTextSource;
import email.cleaning.service.TextSource;

public class DictionaryUtil {

	public static List<String> initialiseDictionary(String fileName) {
		FilePathUtil pathUtil = new FilePathUtil();
		TextSource source = new PlainTextSource();
		return source.getLines(pathUtil.getFilePathFromResources(fileName));
	}
}
