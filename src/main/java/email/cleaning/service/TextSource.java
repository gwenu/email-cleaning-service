package email.cleaning.service;

import java.nio.file.Path;
import java.util.List;

public interface TextSource {
	
	List<String> getLines(Path path);

}
