import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TripleVowelsTest {

    @Test
    void simpleTripleVowelsTest() {
        String[] tests     = {"fooo", "OoO", "baZaa", "fooA", "moraiene"};
        boolean[] expected = {true  , true , false  , true  ,  true};
        for (int i=0;i<tests.length;i++) {
            boolean result = TripleVowels.hasTripleVowels(tests[i]);
            assertEquals(expected[i], result);
        }
    }
}
