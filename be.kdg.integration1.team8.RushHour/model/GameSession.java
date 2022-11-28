package be.kdg.integration1.team8.RushHour.model;

import java.util.ArrayList;
import java.util.Scanner;


// SQL IMPORTS:
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
// -------------------------------

public class GameSession {


//    private int moveCounter = 0;
//    Board board = new Board();
//    Player player = new Player();

    public static void printIntro() {    //print introduction
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
                "\n" +
                "Type 'play' to start playing:\n" +
                "\n" +
                "Press ‘?’ to view the “How To Play” page:\n" +
                "Type ‘LB’ to view the leaderboard:\n" +
                "Type r to view the rules of the game");
    }

    public static void printRules() {
        System.out.println("_______  _____  _____  _____     ________   ______   \n" +
                "|_   __ \\|_   _||_   _||_   _|   |_   __  |.' ____ \\\n" +
                "  | |__) | | |    | |    | |       | |_ \\_|| (___ \\_| \n" +
                "  |  __ /  | '    ' |    | |   _   |  _| _  _.____`.  \n" +
                " _| |  \\ \\_ \\ \\__/ /    _| |__/ | _| |__/ || \\____) | \n" +
                "|____| |___| `.__.'    |________||________| \\______.' \n" +
                "\n" +
                "You’re playing a car trying to navigate through the safari.\n" +
                "Each piece can be moved either up and down, or left and right, depending on how it is positioned.\n" +
                "Your Safari Jeep can be moved left or right. Your goal is to get to the exit on the far-right side of the board by moving the animals and your car in order to create a clear path towards the exit.\n" +
                "       .-\"-.            .-\"-.            .-\"-. \n" +
                "     _/_-.-_\\_        _/.-.-.\\_        _/.-.-.\\_ \n" +
                "    / __} {__ \\      /|( o o )|\\      ( ( o o ) ) \n" +
                "   / //  \"  \\\\ \\    | //  \"  \\\\ |      |/  \"  \\|    \n" +
                "  / / \\'---'/ \\ \\  / / \\'---'/ \\ \\      \\'/^\\'/        \n" +
                "  \\ \\_/`\"\"\"`\\_/ /  \\ \\_/`\"\"\"`\\_/ /      /`\\ /`\\ \n" +
                "   \\           /    \\           /      /  /|\\  \\\n" +
                "\n" +
                "Type ‘exit’ to exit this page:\n" +
                "Press ‘?’ to view the “How To Play” page:\n" +
                "Type ‘LB’ to view the leaderboard:\n" +
                "Type 'play' to start playing!");
    }//print rules

    public static void printHowTo() {//print how-to
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
                "Step 1: Select which piece you want to move (animal or car) by typing their initials as shown on the gameboard (‘L’ for lion, ‘C’ for Car, ‘R’ for rhino etc.)\n" +
                "\n" +
                "Step 2: Choose the direction in which you want to move the piece. (Note that the piece can only be moved on the axis that it’s facing. \n" +
                "[‘U’-- UP] [‘D’-- DOWN] [‘L’ -- LEFT] [‘R’ – RIGHT)]\n" +
                "Step 3: Type in the amount of times you want the chosen piece to move (1..4)\n" +
                "\n" +
                "Type ‘exit’ to exit this page:\n" +
                "Type ‘rules’ to view the rules page:\n" +
                "Type ‘LB’ to view the leaderboard:\n" +
                "Type 'play' to start playing!");
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
                "Type ‘exit’ to exit this page:\n" +
                "Press ‘?’ to view the “How To Play” page:\n" +
                "Type ‘rules’ to view the rules:\n" +
                "Type 'play' to start playing!");
    }//print leaderboard



    public static void printSB(String A, int level){

        if ( A == "Scoreboard") {
            try {
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/scoreboard",
                        "postgres", "rentsek247");
    
                Statement statement = connection.createStatement();


                ResultSet resultSet = statement.executeQuery(
                    "SELECT * from score"); //  where level_id==" + level + '"');
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
    
        }
        catch (Exception e){
            System.out.println("Exception happened.");}
        }

    }



    public static void uploadSB(String name){
        try {
    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/scoreboard",
            "postgres", "rentsek247");
    Statement statement = connection.createStatement();

    statement.executeUpdate("INSERT INTO score (player_name) values ('" + name + "')");


    statement.close();
    // note: closing the connections will also close the resultset and statement
    connection.close();
    System.out.println("Connection closed!");

    }
    catch (Exception e){
        System.out.println("Exception happened.");}

    }


        
    


    // Setting Up Session Variables:
    // -----------------------------------------------
    static Scanner keyboard = new Scanner(System.in);
    Board board = new Board();
    int moveCounter = 0;
    String userInput;
    // -----------------------------------------------

    private static void getUserInput() {
        Board newBoard = new Board();
        String input = keyboard.nextLine();

        switch (input.toLowerCase()) {

            case "?": printHowTo();
                getUserInput();
                break;

            case "r": printRules();
                getUserInput();
                break;
            case "lb": printLB();
                getUserInput();
                break;
            case "play":
                /*
                NOTE: Under here is the pre-filled part of the board.
                This will be replaced by readLevel() which will be stored in a .txt file fill the baord
                through that function.
                 */
                ArrayList<Obstacle> fill = new ArrayList<>();


                //RHINO OBSTACLE
                Obstacle rhino = new Obstacle();
                char idChar = 'R';
                ArrayList<Integer> coords1 = new ArrayList<>();
                ArrayList<Integer> coords2 = new ArrayList<>();
                coords1.add(3);
                coords1.add(3);

                coords2.add(3);
                coords2.add(2);

                rhino.insert(rhino, 3,3, idChar); //Rhino TAIL (3, 3)
                rhino.insert(rhino, 3,2, idChar); //Rhino HEAD (3, 2)

                fill.add(rhino);

                //GIRAFFE OBSTACLE
                Obstacle giraffe = new Obstacle();
                idChar = 'G';
                coords1 = new ArrayList<>(); //clears the arraylist
                coords2 = new ArrayList<>(); //clears the arrayList
                coords1.add(4);
                coords1.add(5);
                coords2.add(5);
                coords2.add(5);

                giraffe.insert(giraffe, 4,5, idChar);
                giraffe.insert(giraffe, 5,5, idChar);

                fill.add(giraffe);

                newBoard.populate(fill);
                newBoard.update();
                newBoard.printBoard();
                keyboard.nextLine();
                System.out.println("Select a move: ");
                giraffe.move(giraffe, "left");
                newBoard.update();
                newBoard.printBoard();

                getUserInput();
                break;



            case "exit":printIntro();
        }
    }

    public static void play() {
        // Initiates a game session and actually plays it.
        printIntro();

        // printSB("Scoreboard",0); 
        // uploadSB("Ben");
        // printSB("Scoreboard",0);

        Board newBoard = new Board();
        Player player = new Player(); 
        while(true){
            getUserInput();
        }


        // This is our main game loop, and we will:
        //      1. ASK FOR INPUT START OF LOOP
        //      2. CHECK THE INPUT
        //      3. DO WHAT THE INPUT SAYS
        //      4. UPDATE & PRINT BOARD
        //      5. ----------------------->


    }

}

