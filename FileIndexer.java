import java.io.File;
import java.util.*;

public class FileIndexer {
	private final Tokenizer tokenizer;
	private final Map<String, Set<File>> index = new HashMap<>();

	public FileIndexer(Tokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}

	public void indexFile(File file) {
		List<String> words = tokenizer.tokenize(file);
		for (String word : words) {
			index.computeIfAbsent(word, k -> new HashSet<>()).add(file);
		}
		System.out.println("Indexed file: " + file.getName());
	}

	public void indexDirectory(File directory) {
		File[] files = directory.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					indexDirectory(file);
				} else {
					indexFile(file);
				}
			}
		}
	}

	public Set<File> query(String word) {
		return index.getOrDefault(word, Collections.emptySet());
	}
}
