package moteurDeRecherche;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PretraiteurStopWords implements Pretraiteur {
    public List<String> traiter(List<String> text) {
        List<String> stopWordsList = Arrays.asList(
                "the", "a", "an",
                "and", "but", "or", "so",
                "he", "she", "they", "it", "we", "you",
                "in", "on", "at", "by", "with", "about", "to", "for",
                "is", "are", "was", "were", "be", "have", "has",
                "that", "this", "which", "what");

        List<String> result = new ArrayList<>();

        
        for (String word : text) {
            if (!stopWordsList.contains(word)) {
                result.add(word);
            }
        }

        return result;
    }
}
