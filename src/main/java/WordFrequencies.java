import java.util.HashMap;
import java.util.Map;

public class WordFrequencies {

    public static void main(String[] args) {

        String word = "Hello";
        String book = "Hello abd, 800[]!!? ?? Hello , hello";
        WordCounter wordCounter = new WordCounter(book);

        System.out.println(wordCounter.getFrequency(word));
    }

}

class WordCounter {
    private final Map<String, Long> wordFrequencies = new HashMap<>();

    public WordCounter(String book) {
        buildDict(book);
    }

    private void buildDict(String book) {
        String[] words = book.split(" ");
        //TODO: remove special characters (e.g.: ! ? . )
        for (String word : words) {
            String formatted = word.toLowerCase().trim();
            Long count = wordFrequencies.getOrDefault(formatted, 0L);
            wordFrequencies.put(formatted, ++count);
        }
    }

    public Long getFrequency(String word) {
        String formatted = word.toLowerCase().trim();
        return wordFrequencies.getOrDefault(formatted, -1L);
    }
}
