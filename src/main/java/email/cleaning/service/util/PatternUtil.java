package email.cleaning.service.util;

import java.util.List;
import java.util.regex.Pattern;

public class PatternUtil {
	
	public static Pattern compilePattern(String path, String pattern) {
		List<String> dictionary = DictionaryUtil.initialiseDictionary(path);
		StringBuilder dictionaryItems = new StringBuilder();
		
		for(String salutation : dictionary) {
			dictionaryItems.append(salutation).append("|");
		}
		
		return Pattern.compile(String.format(pattern, dictionaryItems.substring(0, dictionaryItems.length() - 1)), Pattern.CASE_INSENSITIVE);
	}
}
