public class OffByN implements CharacterComparator{
    int N;
    public OffByN(int N){this.N = N;}
    public boolean equalChars(char x, char y){
        if(x+N == y || x-N == y ){return true;}
        return false;
    }
}