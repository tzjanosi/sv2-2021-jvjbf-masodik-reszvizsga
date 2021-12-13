package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {
    List<String> words = new ArrayList<>();

    public void addWord(String word) {
        if (word.contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        }
        if (!word.toLowerCase().equals(word)) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        for (int i = 0; i < words.size(); i++) {
            if (isElementTwice(i)) {
                return true;
            }
        }
        return false;
    }


    private boolean isElementTwice(int i) {
        for (int j = i + 1; j < words.size(); j++) {
            if (words.get(i).equals(words.get(j))) {
                return true;
            }
        }
        return false;
    }

    public List<String> getWords() {
        return words;
    }
}
