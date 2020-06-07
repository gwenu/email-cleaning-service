package email.cleaning.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import email.cleaning.service.preprocessor.HeaderPreprocessor;
import email.cleaning.service.preprocessor.Preprocessor;
import email.cleaning.service.preprocessor.SalutationPreprocessor;
import email.cleaning.service.preprocessor.SignaturePreprocessor;

public class PreprocessorTest {
	
	private static final List<String> EMAIL_LINES = Arrays.asList("Guten Tag, ich habe jetzt schon mehrfach versucht eine Bestellung aufzugeben, immer",
			"ohne Erfolg. Warum? Lieferadresse soll 99948 Stuttgart, Kirchstraße 11-13 sein.", 
			"Mit freundlichen Grüßen",
			"Katerina Tcheski");
	
	private static final String PREPROCESSED_EMAIL_BODY = " ich habe jetzt schon mehrfach versucht eine Bestellung aufzugeben, immer ohne Erfolg. Warum? Lieferadresse soll 99948 Stuttgart, Kirchstraße 11-13 sein.";
	
	@Test
	public void cleanSalutation() {
		Preprocessor preprocessor = new SalutationPreprocessor();
		List<String> resultList = EMAIL_LINES.stream().map(line -> preprocessor.clean(line))
				.filter(line-> !line.isEmpty()).collect(Collectors.toList());
		
		System.out.println(resultList);
		assertEquals(PREPROCESSED_EMAIL_BODY, resultList.get(0) + " " + resultList.get(1));
	}
	
	@Test
	public void cleanHeader() {
		List<String> lines = TextSourceUtil.getLinesFromFile("testEmail.txt");
		
		Preprocessor preprocessor = new HeaderPreprocessor();
		List<String> resultList = lines.stream().map(line -> preprocessor.clean(line))
				.filter(line-> !line.isEmpty()).collect(Collectors.toList());
		
		System.out.println(resultList);
	}
	
	@Test
	public void cleanSignature() {
		Preprocessor preprocessor = new SignaturePreprocessor();
		List<String> resultList = EMAIL_LINES.stream().map(line -> preprocessor.clean(line))
				.filter(line-> !line.isEmpty()).collect(Collectors.toList());
		
		System.out.println(resultList);
	}
}
