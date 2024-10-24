import java.io.File;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Tokenizer tokenizer = new BasicTokenizer();
		FileIndexer fileIndexer = new FileIndexer(tokenizer);

		while (true) {
			System.out.print("""
        Text File Indexer
        1. Index File
        2. Index Directory
        3. Query Word
        4. Exit
        Choose an option: 
        """);

			int option = 0;
			if (scanner.hasNextInt()) {
				option = scanner.nextInt();  // Read the integer
				scanner.nextLine();  // Consume the newline character
			} else {
				System.out.println("Invalid input. Please enter a number.");
				scanner.nextLine();  // Consume the invalid input
			}

			switch (option) {
				case 1 -> {
					System.out.print("Enter file path: ");
					String filePath = scanner.nextLine();
					File file = new File(filePath);
					if (file.isFile()) {
						fileIndexer.indexFile(file);
					} else {
						System.out.println("Invalid file path.");
					}
					break;
				}

				case 2 -> {
					System.out.print("Enter directory path: ");
					String directoryPath = scanner.nextLine();
					File directory = new File(directoryPath);
					if (directory.isDirectory()) {
						fileIndexer.indexDirectory(directory);
					} else {
						System.out.println("Invalid directory path.");
					}
					break;
				}

				case 3 -> {
					System.out.print("Enter word to query: ");
					String word = scanner.nextLine();
					fileIndexer.query(word).forEach(file -> System.out.println(file.getName()));
					break;
				}

				case 4 -> {
					System.out.println("Exiting...");
					System.exit(0);
				}

				default -> System.out.println("Invalid option. Try again.");
			}
		}
	}
}
