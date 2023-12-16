import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WordCounter {

    public static void main(String[] args) {
        String inputText = getInputFromUser();
        int wordCount = countWords(inputText);
        System.out.println("Total Word Count: " + wordCount);
    }

    private static String getInputFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text or provide a file path:");

        String input = scanner.nextLine().trim();

        if (input.toLowerCase().endsWith(".txt")) {
            // If the input is a file path, read the content of the file
            try {
                Path filePath = Path.of(input);
                input = Files.readString(filePath);
            } catch (IOException e) {
                System.out.println("Error reading the file. Please make sure the file exists.");
                System.exit(1);
            }
        }

        return input;
    }

    private static int countWords(String input) {
        // Split the string into an array of words using space and punctuation as delimiters
        String[] words = input.split("[\\s.,;:!?()]+");

        // Initialize counter variable
        int wordCount = 0;

        // Iterate through the array of words and increment the counter for each word encountered
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }

        return wordCount;
    }
}
