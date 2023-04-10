package game;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class TextTwist {
    private final Parser parser;
    private List<String> said;
    private String sixLetters;
    private String sixLettersList;

    private List<String> sub;
    private boolean done;

    private long startTime;
    private long millis;
    public int scores;
    public TextTwist(){
        parser = new Parser();
        scores=0;
        this.said = new ArrayList<>();
    }
    public void play() throws IOException {
        this.startTime = System.currentTimeMillis();
        printWelcome();
        boolean finished = false;
        done = false;
        while (!finished){
            if(!done){
                if ((double)millis / 1000.0>=120){done=true;continue;}
                Command command = parser.getCommand();
                finished = processCommand(command);
            }
            else {
                System.out.println();
                System.out.println("--- Oops! you ran out of time :P ---");
                break;
            }
        }
        System.out.println();
        System.out.println("     Your total score is " + scores +"/"+sub.size());
        System.out.println("     !Thank you for playing!");
    }
    public void restart() throws IOException {
        this.startTime = System.currentTimeMillis();
        System.out.println("------------------------------------------------------------");
        System.out.println();
        System.out.println("                         RESTART");
        System.out.println("< The score is now reset to 0 and the timer is also reset >");
        String L = getLetters();
        while (sub.size()==0){L = getLetters();}
        System.out.println("     Here are the new 6 letters: "+L);
        timer();
        boolean finished = false;
        done = false;
        while (!finished){
            if(!done){
                if ((double)millis / 1000.0>=120){done=true;continue;}
                Command command = parser.getCommand();
                finished = processCommand(command);
            }
            else {
                System.out.println();
                System.out.println("--- Oops! you ran out of time :P ---");
                break;
            }
        }
        System.out.println();
        System.out.println("     Your total score is " + scores +"/"+sub.size());
        System.out.println("     !Thank you for playing!");
    }
    private boolean processCommand(Command command) throws IOException {
        boolean wantToQuit = false;
        if ((double)millis / 1000.0<120){
            switch (command.getCommandWord()) {
                case "h":
                    printHelp();
                    System.out.println();
                    timer();
                    System.out.println("Here are the 6 letters: " + sixLettersList + "  -->  your total score: " + scores +"/"+sub.size());
                    break;
                case "?":
                    System.out.println("HINT: " + hideSome(said, sub));
                    break;
                case "q":
                    wantToQuit = true;
                    break;
                case "!":
                    listOfWords();
                    System.out.println("Your total score is " + scores + "/" + sub.size());
                    timer();
                    scores = 0;
                    restart();
                    break;
                default:
                    Word cw = new Word(command.getCommandWord()), sl = new Word(sixLetters);
                    if (!said.contains(command.getCommandWord()) && sl.canForm(cw) && sub.contains(command.getCommandWord())) {
                        said.add(command.getCommandWord());
                        scores += 1;
                        System.out.println("Here are the 6 letters: " + sixLettersList + "  -->  your total score: " + scores +"/"+sub.size());
                        timer();
                        if (said.size() == sub.size()) {
                            System.out.println("Yayyyy! You have just discovered all the possible words that can be formed!");
                            System.out.println("                  < Your total score: " + scores + " >");
                            timer();
                            wantToQuit = true;
                        }
                    } else {
                        System.out.println("----- Try again -----");
                        System.out.println("Here are the 6 letters: " + sixLettersList + "  -->  your total score: " + scores +"/"+sub.size());
                        timer();
                    }
                    break;
            }
        }
        return wantToQuit;
    }
    private void printWelcome() throws IOException {
        System.out.println();
        System.out.println("                 !Welcome to the TextTwist game!");
        System.out.println("Type 'h' for help.");
        System.out.println("Type 'q' to quit.");
        System.out.println("Type '?' for the hint.");
        System.out.println("Type '!' to Reveal the answer and start a new game.");
        System.out.println();
        String L = getLetters();
        while (sub.size()==0){L = getLetters();}
        System.out.println("Here are the 6 letters: " + L + "  -->  your total score: " + scores +"/"+sub.size());
        timer();
    }
    private void timer(){
        this.millis = System.currentTimeMillis() - this.startTime;
        System.out.println("Elapsed Time: "+ (double)millis / 1000.0 + " s");
    }
    private String hide(String s){
        String r = "";
        for(int i = 0 ;i<s.length();i++){
            r+='?';
        }
        return r;
    }
    private List<String> hideSome(List<String> said,List<String> sub){
        List<String> r = new ArrayList<>();
        for(int i = 0;i<sub.size();i++){
            if (!said.contains(sub.get(i))){r.add(hide(sub.get(i)));}
            else r.add(sub.get(i));
        }
        String[] list = new String[r.size()];
        for (int i =0;i<r.size();i++){list[i] = (r.get(i));}
        Arrays.sort(list, Comparator.comparing(String::length));
        List<String> wantToReturn = new LinkedList<>();
        wantToReturn.addAll(Arrays.asList(list));

        return wantToReturn;
    }
    private String getLetters() throws IOException {
        List<Character> ll = rand();
        String lll = "";
        for (Character j : ll){lll+=j;}
        this.sixLetters = "";
        for(int i = 0 ; i<6 ; i++){this.sixLetters+=ll.get(i);}
        this.sixLettersList = ll.toString();
        WordDatabase l = new WordDatabase("linuxwords.txt");
        List<Word> s = l.getAllSubWords(new Word(sixLetters),2);
        this.sub = new ArrayList<>();
        for(int j = 0;j<s.size();j++){sub.add(s.get(j).getWord());}
        return ll.toString();
    }
    private List<Character> rand(){
        List<Character> l = new ArrayList<>();
        Random r = new Random();
        while (l.size()<=6){l.add((char)(r.nextInt(26) + 'a'));}
        return l;
    }
    private void printHelp() {
        System.out.println("------------------------------------------------");
        System.out.println("The game starts by displaying 6 random letters.");
        System.out.println("We need you to form words using those letters.");
        System.out.println("You only have 2 minutes to finish the game.");
        System.out.println();
        System.out.println("REMEMBER: The game ends when all words that can be formed have been discovered or the time is up");
    }
    private void listOfWords() throws IOException {

        String[] list = new String[sub.size()];
        for (int i =0;i<list.length;i++){list[i] = (sub.get(i));}
        Arrays.sort(list, Comparator.comparing(String::length));

        List<String> wantToReturn = new LinkedList<>();
        for (int j = 0 ;j<list.length;j++){wantToReturn.add(list[j]);}
        System.out.println("Here are the words that can be formed: ");
        System.out.println(wantToReturn);
    }


}
class Command{
    private String commandWord;
    public Command(String word){
        this.commandWord = word;
    }
    public String getCommandWord() {return commandWord;}
    public boolean isUnknown()
    {
        return (commandWord == null);
    }
}
class Parser{
    private final Scanner reader;
    public String word1;
    public Parser(){reader = new Scanner(System.in);}
    public Command getCommand() {
        String inputLine;
        this.word1=null;
        //System.out.println(TextTwist);
        System.out.print(">> ");     // print prompt
        inputLine = reader.nextLine();
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()){word1 = (tokenizer.next()).toLowerCase();}
        else {word1=null;}
        if(word1 == null){return new Command(null);}
        else {return new Command(word1);}
    }
}

class main{
    public static void main(String[] args) throws IOException {
        try {
            TextTwist a = new TextTwist();
            a.play();
        } catch (FileNotFoundException var2) {
            System.out.println("Can't find the File!");
        }
    }
}