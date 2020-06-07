package email.cleaning.service.preprocessor;

import java.util.ArrayList;
import java.util.List;

public class EmailDataPreprocessor extends DataPreprocessor {
	
	public List<String> process(List<String> lines) {
		List<String> processedLines = new ArrayList<String>();
		for(String line : lines) {
			if(line.isEmpty() || line.trim().length() == 0) {
				continue;
			}
			
			String result = line;
			
			for(Preprocessor preprocesor : preprocessors) {
				if(result.isEmpty()) {
					break;
				} else {
					result = preprocesor.clean(result);
				}
			}
			
			if(SignaturePreprocessor.SIGNATURE_STOP_MARKER.equals(result)) {
				break;
			}
			
			if(!result.isEmpty()) {
				processedLines.add(result);
			}
		}

		return processedLines;
	}

}
