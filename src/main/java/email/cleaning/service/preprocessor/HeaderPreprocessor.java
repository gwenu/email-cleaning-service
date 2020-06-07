package email.cleaning.service.preprocessor;

import java.util.regex.Pattern;

import email.cleaning.service.util.PatternUtil;

public class HeaderPreprocessor implements Preprocessor {
	
	private static final String HEADERS_DICTIONARY_EN= "header-dictionary.en";
	private static final String HEADERS_DICTIONARY_DE= "header-dictionary.de";
	private static final String HEADER_PATTERN = "^(%s).*$";
	
	private Pattern headerPattern;
	
	public HeaderPreprocessor() {
		this.headerPattern = PatternUtil.compilePattern(HEADERS_DICTIONARY_DE, HEADER_PATTERN);
	}
	
	public HeaderPreprocessor(String locale) {
		this.headerPattern = PatternUtil.compilePattern(HEADERS_DICTIONARY_EN, HEADER_PATTERN);
	}

	@Override
	public String clean(String line) {
		return line.replaceAll(headerPattern.pattern(), "");
		
	}
}
