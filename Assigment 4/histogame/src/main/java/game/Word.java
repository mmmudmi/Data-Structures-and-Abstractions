package game;
import histogram.Histogram;
import histogram.SimpleHistogram;

public class Word implements Formable<Word>, Comparable<Word> {
    SimpleHistogram<Character> word;
    int size;
    String Sword;
    public Word(String word){
        this.Sword = word;
        this.size = word.length();
        Character[] w = new Character[word.length()];
        for (int i = 0;i<word.length();i++){
            w[i] = word.charAt(i);
        }
        this.word = new SimpleHistogram<Character>(w);
    }
    public String getWord(){return this.Sword;}
    public Histogram<Character> getHistogram(){return word;}
    @Override
    public boolean canForm(Word other) {
        if(this.getHistogram().getTotalCount()<other.getHistogram().getTotalCount()){return false;}
        for (Character i:other.getHistogram()){
            if(other.getHistogram().getCount(i)>this.getHistogram().getCount(i)){return false;}
        }
        return true;
    }

    @Override
    public int compareTo(Word o) {
        if(this.size<o.size){return -1;}
        if(this.size==o.size){
            for (int i=0;i<size;i++){
                if(this.getWord().charAt(0)<o.getWord().charAt(0)){return -1;}
            }
            if(this.getHistogram().equals(o.getHistogram())){return 0;}
        }
        return +1;
    }
}
