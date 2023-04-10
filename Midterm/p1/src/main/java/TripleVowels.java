public class TripleVowels {
    public static boolean hasTripleVowels(String st) {
        String stLower= st.toLowerCase();
        for (int i=0;i<st.length()-2;i++){
            int count = 0;
            for (int j=0;j<3;j++){
                char s = stLower.charAt(i+j);
                if(s=='a'||s=='e'||s=='i'||s=='o'||s=='u'){count++;}
            }
            if (count>=3){return true;}
        }
        return false;
    }

    public static void main(String[] args) {
        String[] tests     = {"fooo", "OoO", "baZaa", "fooA", "moraiene"};
        boolean[] expected = {true  , true , false  , true  ,  true};
        int numPassed = 0;
        for (int i=0;i<tests.length;i++) {
            boolean result = hasTripleVowels(tests[i]);
            if (result == expected[i]) 
                numPassed++;
        }
        System.out.printf("== Passed %d out of %d cases\n", numPassed, tests.length);
    }
}
