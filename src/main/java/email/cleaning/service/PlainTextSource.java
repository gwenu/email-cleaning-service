package email.cleaning.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PlainTextSource implements TextSource {
	
	@Override
	public List<String> getLines(Path path) {
		List<String> lines = new ArrayList<String>();
		
		try {
			lines = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lines;
	}

}
