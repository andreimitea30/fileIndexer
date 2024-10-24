import java.io.File;
import java.util.List;

public interface Tokenizer {
	List<String> tokenize(File file);
}
