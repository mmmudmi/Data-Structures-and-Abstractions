// IMPORTANT:  Uncomment this file after you have implemented OffByOne

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void Test(){
        OffByOne obo = new OffByOne();
        assertEquals(true,obo.equalChars('a', 'b'));
        assertEquals(true,obo.equalChars('r', 'q'));
        assertEquals(false,obo.equalChars('a', 'e'));
        assertEquals(false,obo.equalChars('z', 'a'));
        assertEquals(false,obo.equalChars('a', 'a'));
    }


} 

