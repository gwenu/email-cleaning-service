package email.cleaning.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import email.cleaning.service.preprocessor.DataPreprocessor;
import email.cleaning.service.preprocessor.EmailDataPreprocessor;
import email.cleaning.service.preprocessor.HeaderPreprocessor;
import email.cleaning.service.preprocessor.SalutationPreprocessor;
import email.cleaning.service.preprocessor.SignaturePreprocessor;

public class GoldTests {
	
	@Test
	public void test() throws IOException {
		DataPreprocessor preprocessor = new EmailDataPreprocessor();
		preprocessor.add(new HeaderPreprocessor())
					.add(new SalutationPreprocessor())
					.add(new SignaturePreprocessor());
		
		String source = TextSourceUtil.getLinesFromFileAsString("emails.json");
		JSONArray emailsArray = new JSONArray(source);
		
		
		for (int i = 0 ; i < emailsArray.length(); i++) {
			JSONObject email = emailsArray.getJSONObject(i);
			
			String uncleared = email.getString("uncleaned");
			String cleared = email.getString("cleaned");
			List<String> uncleanedAsList = new ArrayList<String>(Arrays.asList(uncleared.split("\n")));
			List<String> clearedAsList = new ArrayList<String>(Arrays.asList(cleared.split("\n")));
			
			List<String> processedLines = preprocessor.process(uncleanedAsList);
//			assertEquals(clearedAsList, processedLines);
			System.out.println(processedLines);
			System.out.println(clearedAsList + "\n\n");
			
		}		
	}
}
