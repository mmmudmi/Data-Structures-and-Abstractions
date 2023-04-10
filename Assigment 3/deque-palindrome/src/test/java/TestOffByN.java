import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOffByN {
    @Test
    public void Test(){
        OffByN obo = new OffByN(5);
        assertEquals(true,obo.equalChars('a', 'f'));
        assertEquals(true,obo.equalChars('f', 'a'));
        assertEquals(false,obo.equalChars('f', 'h'));
        assertEquals(true,obo.equalChars('f', 'k'));
    }
}
