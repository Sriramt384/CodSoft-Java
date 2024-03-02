import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
class wordCount {
	public static void main(String[] args) {
		 Scanner hi = new Scanner(System.in);
	        System.out.print("Enter text or a file path to count words: ");
	        String input = hi.nextLine();
	        String text;
	        if (input.endsWith(".txt")) {
	            text = readFile(input);
	        } else {
	            text = input;
	        }
	        String[] words = text.split("[\\s\\p{Punct}]+");
	        int wordCount = 0;
	        String[] stopWords = {"the", "and", "is", "in", "it", "to", "of", "this"};
	        Map<String, Integer> wordFrequency = new HashMap<>();
	        for (String word : words) {
	            if (!isStopWord(word.toLowerCase(), stopWords)) {
	                wordCount++;
	                wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
	            }
	        }
	        System.out.println("Total words: " + wordCount);
	        System.out.println("Word Frequency Statistics:");
	        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	    }
	    private static String readFile(String filePath) {
	        StringBuilder content = new StringBuilder();
	        try {
	            Scanner fileScanner = new Scanner(new File(filePath));
	            while (fileScanner.hasNext()) {
	                content.append(fileScanner.nextLine()).append(" ");
	            }
	            fileScanner.close();
	        } catch (FileNotFoundException e) {
	            System.err.println("File not found. Please provide a valid file path.");
	            System.exit(1);
	        }
	        return content.toString();
	    }

	    private static boolean isStopWord(String word, String[] stopWords) {
	        for (String stopWord : stopWords) {
	            if (word.equals(stopWord)) {
	                return true;
	            }
	        }
	        return false;
	}

}
