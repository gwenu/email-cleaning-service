package email.cleaning.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import email.cleaning.service.preprocessor.DataPreprocessor;
import email.cleaning.service.preprocessor.EmailDataPreprocessor;
import email.cleaning.service.preprocessor.HeaderPreprocessor;
import email.cleaning.service.preprocessor.SalutationPreprocessor;
import email.cleaning.service.preprocessor.SignaturePreprocessor;
import email.cleaning.service.util.FilePathUtil;

public class App {
    
    public static void main(String[] args) {
		System.out.println("--- App is started ---\n\n");
		
		DataPreprocessor preprocessor = new EmailDataPreprocessor();
		preprocessor.add(new HeaderPreprocessor())
					.add(new SalutationPreprocessor())
					.add(new SignaturePreprocessor());
		
		List<String> processedLines = preprocessor.process(getSource());
		writeCleanedEmail(processedLines);
		
		System.out.println(processedLines);
		
		System.out.println("\n\n--- App finished it's work ---");
	}
    
    private static List<String> getSource() {
		TextSource source = new PlainTextSource();
		Path filePath = new FilePathUtil().getFilePath("src/main/resources/appInput/emailInput.txt");
		return source.getLines(filePath);
    }
    
    private static void writeCleanedEmail(List<String> processedLines) {
    	Path filePath = new FilePathUtil().getFilePath("src/main/resources/appInput/emailOutput.txt");
    	
    	try {
			Files.write(filePath , processedLines, Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
