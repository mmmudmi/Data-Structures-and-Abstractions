import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class CommandWords
{
    // a constant array that holds all valid command words
    private static HashMap<String,CommandWord> validCommands;
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() {
        validCommands = new HashMap<>();
        validCommands.put("go",CommandWord.GO);
        validCommands.put("help",CommandWord.HELP);
        validCommands.put("quit",CommandWord.QUIT);
        validCommands.put("look",CommandWord.LOOK);
        validCommands.put("back",CommandWord.BACK);

    }
    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public static CommandWord getCommandWord(String commandWord){
        CommandWord command = validCommands.get(commandWord);
        if(command != null){return command;}
        else {return CommandWord.UNKNOWN;}
    }
    public boolean isCommand(String aString)
    {
        CommandWord command = validCommands.get(aString);
        return command != null;
    }
}
