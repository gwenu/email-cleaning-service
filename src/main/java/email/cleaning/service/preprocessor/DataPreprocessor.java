package email.cleaning.service.preprocessor;

import java.util.ArrayList;
import java.util.List;

public abstract class DataPreprocessor {
	
	protected List<Preprocessor> preprocessors = new ArrayList<>();
	
	public DataPreprocessor add(Preprocessor preprocessor) {
		preprocessors.add(preprocessor);
		return this;
	}
	
	public abstract List<String> process(List<String> lines);
}
