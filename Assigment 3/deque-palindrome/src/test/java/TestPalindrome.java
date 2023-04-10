// IMPORTANT: Uncomment this file after you're done with the Deque interface and wordToDeque
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        Palindrome t = new Palindrome();
        CharacterComparator a = new OffByOne();
        assertEquals(false,t.isPalindrome("hello"));
        assertEquals(true,t.isPalindrome("flake",a));
    }

}

