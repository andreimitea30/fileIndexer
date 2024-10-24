# FileIndexer Application

The **FileIndexer** is a simple, extensible text file indexer that allows users to index files and directories, and query which files contain specific words. It uses basic tokenization and stores the indexed words in a map structure, providing a fast and efficient way to search for words in text files.

## Features

- **File Indexing**: Index individual files to store the occurrence of words.
- **Directory Indexing**: Index all files in a directory and its subdirectories.
- **Word Querying**: Query the indexed files to find which files contain a specific word.
- **Extensible Tokenization**: The tokenization algorithm can be replaced or extended to support different text parsing strategies (e.g., simple splitting by words, custom lexers).
- **Case-insensitive search**: The word queries are case-insensitive, allowing for flexible querying.

## How it Works

The application consists of the following key components:

1. **`Tokenizer` Interface**:
    - Defines a method for tokenizing the contents of a file.
    - Allows different implementations for tokenizing text files.

2. **`BasicTokenizer` Implementation**:
    - Tokenizes text by splitting words based on non-word characters (spaces, punctuation, etc.).
    - Converts tokens (words) to lowercase for case-insensitive search.

3. **`FileIndexer` Class**:
    - Stores a map that links words to the files they are found in.
    - Supports indexing both individual files and entire directories (recursively).
    - Provides functionality to query which files contain a specific word.

4. **`TextFileIndexerApp` Main**:
    - Console-based interface that allows users to interact with the indexer.
    - Provides options to index files, index directories, query words, and exit the application.

## How to Run

In order to select an option, the user needs to provide the corresponding number and press `Enter`. The application will then prompt the user for additional information, such as the file or directory path, or the word to query. If the user provides an invalid input, the application will display an error message and ask for a valid input.

For indexing files and directories, the user needs to provide the absolute path of the file or directory to be indexed. The application will then parse the text files and store the words in the index.

For querying words, the user needs to provide the word to search for. The application will then display a list of files that contain the specified word. If no files are found, the application will just display the options menu again.

The fourth option allows the user to exit the application completely.

## Example Usage

Here is an example of how the application can be used:

1. **Index a File**:
    - Select option `1`.
    - Enter the path of the file to index (e.g., `C:\example\file.txt`).


2. **Index a Directory**:
    - Select option `2`.
    - Enter the path of the file to index (e.g., `C:\example\folder`).


3. **Query a Word**:
    - Select option `3`.
    - Enter the word to search for (e.g., `example`).
    - The application will display a list of files that contain the word.


4. **Exit the Application**:
    - Select option `4`.
    - The application will terminate.