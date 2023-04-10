import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuperPowerTest {

    @Test
    void simpleNumSPTest() {
        assertEquals(3, SuperPower.numSPUpTo(126));
        assertEquals(5, SuperPower.numSPUpTo(149));
        assertEquals(100, SuperPower.numSPUpTo(790));
    }

    @Test
    void simpleKthTest() {
        assertEquals(56, SuperPower.kthSP(1));
        assertEquals(177, SuperPower.kthSP(7));
        assertEquals(789, SuperPower.kthSP(100));
    }
}
