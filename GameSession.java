public class gamesession {
   
   
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
                "Press Enter to start playing:\n" +
                "\n" +
                "Press ‘?’ to view the “How To Play” page:\n" +
                "Type ‘LB’ to view the leaderboard:\n");
    }
    public static void printRules(){
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
                "Type ‘LB’ to view the leaderboard:\n");
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
                "Type ‘LB’ to view the leaderboard:\n");
    }
    public static void printLB(){
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
                "Type ‘rules’ to view the rules:\n");
    }//print leaderboard

    //print board

    public static void play(){
        // Initiates a game session and actually plays it. 



    }
}
