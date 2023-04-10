package game;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

// HINT(s):
//   To read from src/resources/<filename>
//   InputStream is = getClass().getClassLoader().getResourceAsStream(filename);

public class WordDatabase implements IDatabase {
    BufferedReader Breader;
    String name;

    public WordDatabase(String filename) throws FileNotFoundException {
        try {
            this.name = filename;
            this.Breader = new BufferedReader(new FileReader(filename));
        } catch(FileNotFoundException e){
            System.out.println("Can't find the file");
        }
    }
    @Override
    public void add(Word w) throws IOException {
        File current = new File(name);
        BufferedWriter writer = new BufferedWriter(new FileWriter(current,true));
        PrintWriter Pwriter = new PrintWriter(writer);
        Pwriter.println(w.getWord());
        writer.close();
        Pwriter.close();
    }
    @Override
    public void remove(Word w) throws IOException {
        File current = new File(name);
        File tempFile = new File("TempFile.txt");
        BufferedReader cread = new BufferedReader(new FileReader(current));
        BufferedWriter twrite = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        while ((currentLine=cread.readLine())!=null){
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(w.getWord())) continue;
            twrite.write(currentLine+System.getProperty("line.separator"));
        }
        cread.close();
        twrite.close();
        tempFile.renameTo(current);
    }

    @Override
    public List<Word> getWordWithLength(int l) throws IOException {
        List<Word> all = new LinkedList<>();
        File file = new File (name);
        BufferedReader read = new BufferedReader(new FileReader(file));
        String currentLine;
        while ((currentLine=read.readLine())!=null){
            if(new Word(currentLine).size == l){all.add(new Word(currentLine));}
        }
        read.close();
        return all;
    }

    @Override
    public List<Word> getAllSubWords(Word w, int minLen) throws IOException {
        List<Word> all = new LinkedList<>();
        String data;
        while ((data = Breader.readLine())!=null){
            if(w.canForm(new Word(data)) && data.length()>=minLen){
                all.add(new Word(data));
            }
        }
        return all;
    }

    @Override
    public boolean contains(Word o) throws IOException {
        File file = new File (name);
        BufferedReader read = new BufferedReader(new FileReader(file));
        String currentLine;
        while ((currentLine=read.readLine())!=null){
            if(new Word(currentLine).equals(o)){return true;}
        }
        read.close();
        return false;
    }
}
