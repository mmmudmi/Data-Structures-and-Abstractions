package histogram;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;


public class SimpleHistogramTest {

    @Test
    public void testHistogram() {
        Character[] target = {'a','b','c','a'};
        Histogram<Character> h = new SimpleHistogram<>(target);
        h.setCount('f',3);

        Iterator<Character> iter = h.iterator();
        int elemCount = 0;
        while(iter.hasNext()) {
            iter.next();
            elemCount++;
        }

        assertEquals(2, h.getCount('a'));
        assertEquals(1, h.getCount('b'));
        assertEquals(1, h.getCount('c'));
        assertEquals(7, h.getTotalCount());
        h.setCount('a',1);
        assertEquals(6, h.getTotalCount());
        assertEquals(4, elemCount);
        Character[] t = {'a','b','a','c'};
        Histogram<Character> tt = new SimpleHistogram<>(t);
        assertEquals(false,tt.equals(h));






    }
}

