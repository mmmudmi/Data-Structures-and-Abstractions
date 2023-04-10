import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class NearFibTest {

    @Test
    void simpleNumNearFib() {
        NearFib nearFib = new NearFib();

        long[] test0 = {5, 3, 6, 10, 19, 25, 111};
        assertEquals(5, nearFib.numNearFib(test0, 2L));

        long[] test1 = {95, 350, 6111, 1_028_693_860, 19_000, 222_215, 1_119_826};
        assertEquals(4, nearFib.numNearFib(test1, 12345L));
    }

    @Test
    void longerNumNearFib() {
        long[] test0 = new long[20_000_000];
        Random rng = new Random(1502);
        for (int i=0;i<test0.length;i++) {
            test0[i] = rng.nextLong() % 100_000_000_001L;
        }
        NearFib nearFib = new NearFib();
        assertEquals(4723, nearFib.numNearFib(test0, 999999));
    }
}