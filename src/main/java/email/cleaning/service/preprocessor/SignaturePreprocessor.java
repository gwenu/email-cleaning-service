package email.cleaning.service.preprocessor;

import java.util.regex.Pattern;

import email.cleaning.service.util.PatternUtil;

public class SignaturePreprocessor implements Preprocessor {
	
	public static final String SIGNATURE_STOP_MARKER = "SIGNATURE_STOP_MARKER";

	private static final String SIGNATURE_DICTIONARY_EN= "signature-dictionary.en";
	private static final String SIGNATURE_DICTIONARY_DE= "signature-dictionary.de";
	private static final String SIGNATURE_PATTERN = "^(%s).*$";
	
	private Pattern signaturePattern;

	public SignaturePreprocessor() {
		this.signaturePattern = PatternUtil.compilePattern(SIGNATURE_DICTIONARY_DE, SIGNATURE_PATTERN);
	}
	
	public SignaturePreprocessor(String locale) {
		this.signaturePattern = PatternUtil.compilePattern(SIGNATURE_DICTIONARY_EN, SIGNATURE_PATTERN);
	}

	@Override
	public String clean(String line) {  
		return line.replaceAll(signaturePattern.pattern(), SIGNATURE_STOP_MARKER);
	}
}
