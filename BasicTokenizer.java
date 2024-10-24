import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasicTokenizer implements Tokenizer {
	@Override
	public List<String> tokenize(File file) {
		List<String> words = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split("\\W+");
				for (String token : tokens) {
					if (!token.isEmpty()) {
						words.add(token.toLowerCase());
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Error reading file: " + file.getAbsolutePath());
		}
		return words;
	}
}
