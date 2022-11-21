package Safari;


public class Main {


    private static String board = """
        ╔═══╦═══════╦═══════╦═══════╦═══════╦═══════╦═══════╗
        ║ 0 ║   1   ║   2   ║   3   ║   4   ║   5   ║   6   ║
        ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╣
        ║ 1 ║       ║       ║       ║       ║       ║       ║
        ║   ║       ║       ║       ║       ║       ║       ║
        ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╣
        ║ 2 ║       ║       ║       ║       ║       ║       ║   
        ║   ║       ║       ║       ║       ║       ║       ║   
        ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╣
        ║ 3 ║       ║       ║       ║       ║       ║       ║
        ║   ║       ║       ║       ║       ║       ║       ║   
        ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╣
        ║ 4 ║       ║       ║       ║       ║       ║       ║
        ║   ║       ║       ║       ║       ║       ║       ║   
        ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╣═══════╣
        ║ 5 ║       ║       ║       ║       ║       ║       ║ 
        ║   ║       ║       ║       ║       ║       ║       ║   
        ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╣═══════╣
        ║ 6 ║       ║       ║       ║       ║       ║       ║
        ║   ║       ║       ║       ║       ║       ║       ║       
        ╚═══╩═══════╩═══════╩═══════╩═══════╩═══════╝═══════╝
                    """;

    public static void main (String args[]){

    

    int[][] MDarray = new int[10][10];

    
    System.out.print(" ---------------------------------------\n");
    for(int i = 0; i < MDarray.length; i++){

        System.out.print("| ");
        for(int j = 0; j < MDarray[0].length; j++){
            System.out.print(j + " | ");
        }

        System.out.println();


    }
    System.out.print(" ---------------------------------------\n");



    // Basic Game Runthrough 


    // Scanner kb = new Scanner(System.in);

    // System.out.println("Welcome to the SAFARI!");
    // System.out.println("What is your name?");
    // String playerName = kb.nextLine(); 




    // System.out.println(board);

    }
}
