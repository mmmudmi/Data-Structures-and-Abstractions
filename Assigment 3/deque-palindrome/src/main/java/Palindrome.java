
public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> a = new LinkedListDeque<Character>();
        for(int i=word.length()-1;i>=0;i--){
            a.addFirst(word.charAt(i));
        }
        return a;
    }
    public boolean isPalindrome(String word){
        if(word.length()<=1){return true;}
        Deque<Character> a = wordToDeque(word);
        Deque<Character> b = wordToDeque(word);
        for(int j=0;j<word.length();j++){
            if(a.removeFirst()!=b.removeLast()){return false;}
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length()<=1){return true;}
        Deque<Character> a = wordToDeque(word);
        Deque<Character> b = wordToDeque(word);
        if(word.length()%2 != 0){
            for(int j=0;j<word.length()/2;j++){
                if(!cc.equalChars(a.removeFirst(),b.removeLast())){return false;}
            }
        }
        else {
            for(int j=0;j<word.length();j++){
                if(!cc.equalChars(a.removeFirst(),b.removeLast())){return false;}
            }
        }
        return true;
    }
}
