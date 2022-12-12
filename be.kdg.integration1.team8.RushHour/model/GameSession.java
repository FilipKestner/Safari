package model;

import java.util.ArrayList;
import java.util.Scanner;

// SQL IMPORTS:
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
// -------------------------------

// File Reading Imports:
import java.io.File;
import java.io.FileNotFoundException;
// -------------------------------


public class GameSession {
    // Setting Up Session Variables:
    // -----------------------------------------------
    static Scanner keyboard = new Scanner(System.in);
    private Board board = new Board();
    private int moveCounter = 0;
    private String userInput;

    enum direction { // Enum to make directions 
        UP,          // objects and not just
        DOWN,        // concepts :)))
        LEFT,
        RIGHT
    }
    // -----------------------------------------------

    public static void printIntro() { // print introduction
        System.out.println(" ______        _       ________    _       _______     _____  \n" +
                ".' ____ \\      / \\     |_   __  |  / \\     |_   __ \\   |_   _| \n" +
                "| (___ \\_|    / _ \\      | |_ \\_| / _ \\      | |__) |    | |   \n" +
                " _.____`.    / ___ \\     |  _|   / ___ \\     |  __ /     | |   \n" +
                "| \\____) | _/ /   \\ \\_  _| |_  _/ /   \\ \\_  _| |  \\ \\_  _| |_  \n" +
                " \\______.'|____| |____||_____||____| |____||____| |___||_____| \n" +
                "\n" +
                "\n" +
                "                 _.---------------------.                           \n" +
                "                 .'_______________________|              \n" +
                "                 //    _|||    || |   | | |\n" +
                "          ______//_\\__j_|||____|| \"---\" | |  _\n" +
                "         /-----+-|p  ==,|||p ==,|_______|_|-|W|\n" +
                "        _j,====. |b_____|||b    /_____    | |W|\n" +
                "       |_) ,---.`.`------'|----.',---.`.__|_|W|\n" +
                "         `/ .-. \\\\`======__====// .-. \\`---'\"\"\n" +
                "          \\ `-' / \"\"\"\"\"\"\"  \"\"\"\" \\ `-' /\n" +
                "           `---'                 `---'  \n" +
                "\n" +
                "             _                 __                 \n" +
                "      __.--**\"\"\"**--...__..--**\"\"\"\"*-.            \n" +
                "    .'                                `-.         \n" +
                "  .'                         _           \\        \n" +
                " /                         .'        .    \\   _._ \n" +
                ":                         :          :`*.  :-'.' ;\n" +
                ";    `                    ;          `.) \\   /.-' \n" +
                ":     `                             ; ' -*   ;    \n" +
                "       :.    \\           :       :  :        :    \n" +
                " ;     ; `.   `.         ;     ` |  '             \n" +
                " |         `.            `. -*\"*\\; /        :     \n" +
                " |    :     /`-.           `.    \\/`.'  _    `.   \n" +
                " :    ;    :    `*-.__.-*\"\"\":`.   \\ ;  'o` `. /   \n" +
                "       ;   ;                ;  \\   ;:       ;:   ,/\n" +
                "  |  | |                       /`  | ,      `*-*'/ \n" +
                "  `  : :  :                /  /    | : .    ._.-'  \n" +
                "   \\  \\ ,  \\              :   `.   :  \\ \\   .'     \n" +
                "    :  *:   ;             :    |`*-'   `*+-*       \n" +
                "    `**-*`\"\"               *---*\n" +
                "\n" +
                "Enter 'play' to start the game:\n" +
                "Enter '?' to view the “How To Play” page:\n" +
                "Enter 'LB' to view the leaderboard:\n" +
                "Enter 'r' to view the rules of the game");
    }

    public static void printRules() {
        System.out.println("_______  _____  _____  _____     ________   ______   \n" +
                "|_   __ \\|_   _||_   _||_   _|   |_   __  |.' ____ \\\n" +
                "  | |__) | | |    | |    | |       | |_ \\_|| (___ \\_| \n" +
                "  |  __ /  | '    ' |    | |   _   |  _| _  _.____`.  \n" +
                " _| |  \\ \\_ \\ \\__/ /    _| |__/ | _| |__/ || \\____) | \n" +
                "|____| |___| `.__.'    |________||________| \\______.' \n" +
                "\n" +
                "You're playing a car trying to navigate through the safari.\n" +
                "Each piece can be moved either up and down, or left and right, depending on how it is positioned.\n" +
                "Your Safari Jeep can be moved left or right. Your goal is to get to the exit on the far-right side of the board by moving the animals and your car in order to create a clear path towards the exit.\n"
                +
                "       .-\"-.            .-\"-.            .-\"-. \n" +
                "     _/_-.-_\\_        _/.-.-.\\_        _/.-.-.\\_ \n" +
                "    / __} {__ \\      /|( o o )|\\      ( ( o o ) ) \n" +
                "   / //  \"  \\\\ \\    | //  \"  \\\\ |      |/  \"  \\|    \n" +
                "  / / \\'---'/ \\ \\  / / \\'---'/ \\ \\      \\'/^\\'/        \n" +
                "  \\ \\_/`\"\"\"`\\_/ /  \\ \\_/`\"\"\"`\\_/ /      /`\\ /`\\ \n" +
                "   \\           /    \\           /      /  /|\\  \\\n" +
                "\n" +
                "Enter 'play' to start the game:\n" +
                "Enter '?' to view the 'How To Play' instructions:\n" +
                "Enter 'LB' to view the leaderboard:\n" +
                "Enter 'r' to view the rules of the game");
    }// print rules

    public static void printHowTo() {// print how-to
        System.out.println("____  ____   ___   ____      ____   _________    ___    \n" +
                "|_   ||   _|.'   `.|_  _|    |_  _| |  _   _  | .'   `.  \n" +
                "  | |__| | /  .-.  \\ \\ \\  /\\  / /   |_/ | | \\_|/  .-.  \\ \n" +
                "  |  __  | | |   | |  \\ \\/  \\/ /        | |    | |   | | \n" +
                " _| |  | |_\\  `-'  /   \\  /\\  /        _| |_   \\  `-'  / \n" +
                "|____||____|`.___.'     \\/  \\/        |_____|   `.___.'  \n" +
                " _______  _____          _     ____  ____                \n" +
                "|_   __ \\|_   _|        / \\   |_  _||_  _|               \n" +
                "  | |__) | | |         / _ \\    \\ \\  / /                 \n" +
                "  |  ___/  | |   _    / ___ \\    \\ \\/ /                  \n" +
                " _| |_    _| |__/ | _/ /   \\ \\_  _|  |_                  \n" +
                "|_____|  |________||____| |____||______|                 \n" +
                " \n" +
                "                          ,%%%%%%%,\n" +
                "                        ,%%/\\%%%%/\\%,\n" +
                "                       ,%%%\\c \"\" J/%%,\n" +
                "  %.                   %%%%/ d  b \\%%%\n" +
                "  `%%.         __      %%%%    _  |%%%\n" +
                "   `%%      .-'  `\"~--\"`%%%%(=_Y_=)%%'\n" +
                "    //    .'     `.     `%%%%`\\7/%%%'____\n" +
                "   ((    /         ;      `%%%%%%%'____)))\n" +
                "   `.`--'         ,'   _,`-._____`-,   \n" +
                "     `\"\"\"`._____  `--,`          `)))\n" +
                "                `~\"-)))\n" +
                " \n" +
                "Step 1: Select which piece you want to move (animal or car) by typing their initials as shown on the gameboard ('L' for lion, 'C' for Car, 'R' for rhino etc.)\n"
                +
                "\n" +
                "Step 2: Choose the direction in which you want to move the piece. (Note that the piece can only be moved on the axis that it's facing. \n"
                +
                "\t['U'-- UP] ['D'-- DOWN] ['L' -- LEFT] ['R' – RIGHT)]\n" +
                "Step 3: Type in the amount of times you want the chosen piece to move (1..4)\n" +
                "\n" +
                "Enter 'play' to start the game:\n" +
                "Enter '?' to view the “How To Play” page:\n" +
                "Enter 'LB' to view the leaderboard:\n" +
                "Enter 'r' to view the rules of the game");
    }

    public static void printLB() {
        System.out.println(" _____     ________       _       ______   ________  _______          \n" +
                " |_   _|   |_   __  |     / \\     |_   _ `.|_   __  ||_   __ \\         \n" +
                "   | |       | |_ \\_|    / _ \\      | | `. \\ | |_ \\_|  | |__) |______  \n" +
                "   | |   _   |  _| _    / ___ \\     | |  | | |  _| _   |  __ /|______| \n" +
                "  _| |__/ | _| |__/ | _/ /   \\ \\_  _| |_.' /_| |__/ | _| |  \\ \\_       \n" +
                " |________||________||____| |____||______.'|________||____| |___|      \n" +
                "|_   _ \\   .'   `.     / \\     |_   __ \\   |_   _ `.                   \n" +
                "  | |_) | /  .-.  \\   / _ \\      | |__) |    | | `. \\                  \n" +
                "  |  __'. | |   | |  / ___ \\     |  __ /     | |  | |                  \n" +
                " _| |__) |\\  `-'  /_/ /   \\ \\_  _| |  \\ \\_  _| |_.' /                  \n" +
                "|_______/  `.___.'|____| |____||____| |___||______.'  \n" +
                "                     _.---._     .---.\n" +
                "            __...---' .---. `---'-.   `.\n" +
                "  ~ -~ -.-''__.--' _.'( | )`.  `.  `._ :\n" +
                " -.~~ .'__-'_ .--'' ._`---'_.-.  `.   `-`.\n" +
                "  ~ ~_~-~-~_ ~ -._ -._``---. -.    `-._   `.\n" +
                "    ~- ~ ~ -_ -~ ~ -.._ _ _ _ ..-_ `.  `-._``--.._\n" +
                "     ~~-~ ~-_ _~ ~-~ ~ -~ _~~_-~ -._  `-.  -. `-._``--.._.--''. ~ -~_\n" +
                "         ~~ -~_-~ _~- _~~ _~-_~ ~-_~~ ~-.___    -._  `-.__   `. `. ~ -_~\n" +
                "             ~~ _~- ~~- -_~  ~- ~ - _~~- _~~ ~---...__ _    ._ .` `. ~-_~\n" +
                "                ~ ~- _~~- _-_~ ~-_ ~-~ ~_-~ _~- ~_~-_~  ~--.....--~ -~_ ~\n" +
                "                     ~ ~ - ~  ~ ~~ - ~~-  ~~- ~-  ~ -~ ~ ~ -~~-  ~- ~-~                 \n" +
                "                                                                      \n" +
                "                                           LEVEL 1\n" +
                " \n" +
                " \n" +
                "JOHN SMITH   XXX MOVES       4. JACK BAKER   XXX MOVES       7. T. STARK   XXX MOVES \n" +
                "JANE DOE\t XXX MOVES       5. M. JACKSON   XXX MOVES       8. F. BAGGINS XXX MOVES\n" +
                "JACK JONES   XXX MOVES       6. T. SWIFT     XXX MOVES       9. B. OBAMA   XXX MOVES\n" +
                " \n" +
                "                                           LEVEL 2\n" +
                " \n" +
                " \n" +
                "JOHN JONES   XXX MOVES       4. M. JORDAN   XXX MOVES        7. D. DUCK    XXX MOVES\n" +
                "JANE SMITH   XXX MOVES       5. B. WAYNE    XXX MOVES        8. M. MOUSE   XXX MOVES\n" +
                "JACK BAKER   XXX MOVES       6. P. PARKER   XXX MOVES        9. O. KENOBI  XXX MOVES\n" +
                " \n" +
                "Enter 'play' to start the game:\n" +
                "Enter '?' to view the “How To Play” page:\n" +
                "Enter 'LB' to view the leaderboard:\n" +
                "Enter 'r' to view the rules of the game");
    }// print leaderboard

    public static void printSB(String A, int level) {

        if (A == "Scoreboard") {
            try {
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/scoreboard",
                        "postgres", "rentsek247");

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(
                        "SELECT * from score"); // where level_id==" + level + '"');
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name1 = resultSet.getString(2);
                    int sqlLVL = resultSet.getInt(3);
                    int moves = resultSet.getInt(4);
                    System.out.println("id:" + id + " name:" + name1 + " level:" + sqlLVL + " moves:" + moves);
                }
                resultSet.close();
                statement.close();
                // note: closing the connections will also close the resultset and statement
                connection.close();
                System.out.println("Connection closed!");

            } catch (Exception e) {
                System.out.println("Exception happened.");
            }
        }

    }

    public static void uploadSB(String name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/scoreboard",
                    "postgres", "rentsek247");
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO score (player_name) values ('" + name + "')");

            statement.close();
            // note: closing the connections will also close the resultset and statement
            connection.close();
            System.out.println("Connection closed!");

        } catch (Exception e) {
            System.out.println("Exception happened.");
        }

    }



    private String getUserInput() {
        this.userInput = keyboard.nextLine();
        return userInput;
        // switch (input.toLowerCase()) {

        //     case "?":
        //         printHowTo();
        //         getUserInput();
        //         break;

        //     case "r":
        //         printRules();
        //         getUserInput();
        //         break;
        //     case "lb":
        //         printLB();
        //         getUserInput();
        //         break;
    }

    private char selectObstacle(){
        // Call this function when it is time for the
        // user to select the obstacle which they would 
        // like to move. This function is also responsible for error handling. 

        return 'R';
    }

    private direction getDirection(Obstacle obstacle){
        // Call this function when it is time for the
        // user to select which direction they would
        // like to move the obstacle in. 

        return direction.UP; 
    }

    private int getDistance(){
        // Call this function when you would like
        // the user to enter the amount of spaces
        // they want their selected obstacle to
        // move. 

        return 0; 

    }

    private boolean getMove(){
        // Combines all 3 steps of the user selecting
        // a move and combines them to allow for more
        // holisitic error checking as well as 
        // repetition of requests if invalid input
        // is entered. 

        return false;
    }




    private void extractLevel(int levelNumber){
        // Populates this.Board with the appropriate obstacles
        // that mimics the start state of the level levelNumber

        try{
            File levelFile = new File("be.kdg.integration1.team8.RushHour/model/levels.txt");
            Scanner lineReader = new Scanner(levelFile); 

            String curLine = ""; 

            // GET TO THE STARTING LINE OF LEVEL levelNumber
            while(lineReader.hasNextLine()){
                curLine = lineReader.nextLine(); 

                if(curLine.startsWith("--"+levelNumber)){
                    System.out.println("FOUND MY LEVEL: " + levelNumber);
                    curLine = lineReader.nextLine();
                    break;
                }
            }
            // -------------------------------------------------

            // READ EACH LINE OF LEVEL levelNumber

            String[] splitLine; 
            StringBuilder entireLevelString = new StringBuilder(); 

            while(!curLine.startsWith("END")){
                //System.out.println(curLine);

                //splitLine = curLine.split('|');
                // |R | 0,1 | 0,2 | 0,3
                // |0 |  1  |  2  |  3

                entireLevelString.append(curLine);
                curLine = lineReader.nextLine(); 
            }

            //System.out.println(entireLevelString);

            stringToLevel(entireLevelString.toString());
            // ----------------------------------------
            lineReader.close();
        } catch (FileNotFoundException e){
            System.out.println("FILE NOT FOUND DUMMIE!");
            e.printStackTrace();
        }
    }

    private void stringToLevel(String stringLevel){
        // Converts String stringLevel (which is created in extract level)
        // into the actual board. This code might be reused when saving/loading from database
        // so had to put it into a function. 


        // 1. Convert the entire String into an array
        // EACH INDEX IS A NEW OBSTACLE TO CONVERT 
        String[] obstacleStrings = stringLevel.split("#");
        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>(); 


        // 2. Iterate through EACH INDEX, AND MAKE AN OBSTACLE
        for(String x : obstacleStrings){
            Obstacle newObstacle = new Obstacle(); 


            char animalChar = x.charAt(0); // First Character is the Animal Char
            String[] stringNodes = x.substring(3).replaceAll("\\s+","").split("\\|");

            
            Node[] nodes; 
            for( String n : stringNodes){
                System.out.println("\'"+ n + "\'");

                //Node newNode = new Node((int)n.charAt(0), (int)n.charAt(2),null,animalChar);
                newObstacle.insert(newObstacle,Character.getNumericValue(n.charAt(0)),
                    Character.getNumericValue(n.charAt(2)), animalChar); 
                
            }
            newObstacle.printList(); 
            obstacles.add(newObstacle);

            System.out.println();
        }

        this.board.populate(obstacles); 
        this.board.update(); 
        this.board.printBoard();
    }

    private String levelToString(){
        // Converts the current board state into a giant String object
        // to be saved in the database

        return "";
    }


// ########################################################################################################################
// ########################################################################################################################
// ########################################################################################################################



    public void play() {

        // Initialize Variables to be Used:
        Board newBoard = new Board();   // Board Object   :: all things board related
        Player player = new Player();   // Player Object  :: stores player data
        String userInput;               // User Input     :: stores LAST user input AT ALL TIMES
        Boolean gameState = true;       // Continue Check :: Dictates whether the game continues to loop



    // (1) Introductary Sequence
        printIntro();

        getUserInput();  
 
        while(!this.userInput.equals("play")){
            switch (this.userInput.toLowerCase()){
                case "?":
                    printHowTo(); 
                    break;
                case "r":
                    printRules();
                    break;
                case "lb":
                    printLB();
                    break;
            }

            getUserInput(); 
            break; 
        }

    // (2) Actual Game Begins
        System.out.println("-------- THE GAME HAS BEGUN --------");


        // FUNCTION TO GENERAT THE LEVEL BASED ON LEVEL_ID 
        extractLevel(1);
        // ------------------------------------------------


        boolean check = this.board.checkWin(); 
        System.out.println(check);

        System.out.println("-------------------------------");

        // 0. Ask User for Level #  
        // 1. Generate Board from File


        // 2. Begin Game Loop
        //      * Anytime User enters 'r', '?', 'LB'
        //        we must print appropriate function.
    
    }
}