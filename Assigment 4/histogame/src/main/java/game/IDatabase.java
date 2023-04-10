package game;

import java.io.IOException;
import java.util.List;

public interface IDatabase {
    // Adds a word to the database.
    void add(Word w) throws IOException;

    // Removes w from the database and has no effects if w is not present
    void remove(Word w) throws IOException;

    // Returns a List of Words in the database whose length is exactly l.
    List<Word> getWordWithLength(int l) throws IOException;

    // Returns a List of Words in the database whose length is at least minLen
    // and which can be formed from all or some of the letters of the word w
    List<Word> getAllSubWords(Word w, int minLen) throws IOException;

    // Returns true if the word o is in the database and false otherwise
    boolean contains(Word o) throws IOException;
}
