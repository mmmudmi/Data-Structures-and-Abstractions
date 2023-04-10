/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
import java.util.ArrayList;
import java.util.Random;
public class Game
{
    private final Parser parser;
    private Room currentRoom;
    ArrayList<Room> previous = new ArrayList<>();
    Room outside, theater, pub, lab, office, magic, physicsLab, library, art;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        magic = new Room("in a magic transporter room");
        physicsLab = new Room("in a physics lab on the 2nd floor");
        library = new Room("in a library on the 2nd floor");
        art = new Room("in an art room on the 2nd floor");

        // initialise room exits
        outside.setExits("east", theater);
        outside.setExits("south", lab);
        outside.setExits("west", pub);
        outside.setExits("north",magic);
        theater.setExits("west",outside);
        theater.setExits("up",art);
        pub.setExits("east",outside);
        lab.setExits("north",outside);
        lab.setExits("east",office);
        lab.setExits("up",physicsLab);
        office.setExits("west",lab);
        office.setExits("up",library);
        physicsLab.setExits("down",lab);
        physicsLab.setExits("east",library);
        library.setExits("west",physicsLab);
        library.setExits("north",art);
        art.setExits("down",theater);
        art.setExits("south",library);



        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(getLocationInfo());

    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        CommandWord commandWord = CommandWords.getCommandWord(command.getCommandWord());
        switch (commandWord){
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command);
                break;
            case LOOK:
                lookAtRoom();
                break;
            case QUIT:
                wantToQuit = quit(command);
                break;
            case BACK:
                goBack(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);
        if(nextRoom==magic){
            int i = new Random().nextInt(7);
            Room[] rooms = {theater, pub, lab, office, library, physicsLab, art};
            currentRoom = rooms[i];
            nextRoom = rooms[i];
        }
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            previous.add(currentRoom);
            currentRoom = nextRoom;
            System.out.println(getLocationInfo());
        }
    }
    private void goBack(Command command){
        String direction = command.getSecondWord();
        if(command.hasSecondWord()) {
            System.out.println("Back where?");
            return;
        }
        if (previous.size() == 0) {
            System.out.println("You have nowhere to go back to!");
        }
        else {
            currentRoom = previous.get(previous.size()-1);
            System.out.println(getLocationInfo());
            if(previous.size()>0) {previous.remove(previous.size()-1);}
        }
    }
    private void lookAtRoom() {System.out.println(getLocationInfo());}
    private String getLocationInfo(){
        StringBuilder info = new StringBuilder();
        info.append("You are ").append(currentRoom.getDescription());
        info.append("\n");
        info.append("Exits: ");
        if(currentRoom.getExit("north") != null) {
            info.append("north ");
        }
        if(currentRoom.getExit("east") != null) {
            info.append("east ");
        }
        if(currentRoom.getExit("south") != null) {
            info.append("south ");
        }
        if(currentRoom.getExit("west") != null) {
            info.append("west ");
        }
        if(currentRoom.getExit("up") != null) {
            info.append("up ");
        }
        if(currentRoom.getExit("down") != null) {
            info.append("down ");
        }
        return info.toString();
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
