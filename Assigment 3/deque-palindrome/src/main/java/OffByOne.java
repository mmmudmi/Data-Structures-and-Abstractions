public class OffByOne implements CharacterComparator {
    public boolean equalChars(char x, char y){
        if(x+1 == y || x-1 == y ){return true;}
        return false;
    }
}