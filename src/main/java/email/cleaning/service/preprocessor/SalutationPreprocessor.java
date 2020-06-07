package email.cleaning.service.preprocessor;

import java.util.regex.Pattern;

import email.cleaning.service.util.PatternUtil;

public class SalutationPreprocessor implements Preprocessor {
	
	private static final String SALUTATION_DICTIONARY_EN= "salutation-dictionary.en";
	private static final String SALUTATION_DICTIONARY_DE= "salutation-dictionary.de";
	private static final String SALUTATION_PATTERN = "^(%s)(.[,!]?)";
	
	private Pattern salutationPattern;
	
	public SalutationPreprocessor() {
		this.salutationPattern = PatternUtil.compilePattern(SALUTATION_DICTIONARY_DE, SALUTATION_PATTERN);
	}
	
	public SalutationPreprocessor(String locale) {
		this.salutationPattern = PatternUtil.compilePattern(SALUTATION_DICTIONARY_EN, SALUTATION_PATTERN);
	}

	@Override
	public String clean(String line) {
		return line.replaceAll(salutationPattern.pattern(), "");
	}

}
