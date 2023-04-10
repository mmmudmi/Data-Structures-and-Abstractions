import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PerfectHidingTest {
    WeightedEdge Edge(int u, int v, int c) { return WeightedEdge.Edge(u, v, c); }

    @Test
    public void phSimpleTest() throws Exception {
        List<WeightedEdge> passages = new ArrayList<>(Arrays.asList(
                                Edge(1, 2, 1),
                                Edge(2, 3, 2),
                                Edge(2, 4, 5)));
        int expcted = 6;
        assertEquals(expcted, PerfectHiding.bestSpotDistance(passages));
    }
}
