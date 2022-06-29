package WordsInvaders;

import java.util.ArrayList;
import java.util.List;

public class WordsDB {

    public List<Word> words;
    /**
     * Initially the words databases will be stored just in memory for concept test
     * this must be improved for scalability.
     *
     * Temporally only feeded with english and spanish words, pending to complement.
     */
    public WordsDB() {
        words = new ArrayList<>();
        words.add(createWord("Gato", "Cat", "Chat"));
        words.add(createWord("Perro", "Dog", "Chien"));
        words.add(createWord("Casa", "House", ""));
        words.add(createWord("Comida", "Food", ""));
        words.add(createWord("Mujer", "Woman", ""));
        words.add(createWord("Hombre", "Men", ""));
        words.add(createWord("Computador", "Computer", ""));
    }

    private static Word createWord(String spanish, String english, String french) {
        Word word = new Word(null);
        word.textEnglish = english;
        word.textFrench = french;
        word.textSpanish = spanish;

        return word;
    }
}
