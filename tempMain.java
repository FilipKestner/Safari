import java.util.ArrayList;

public class tempMain {


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

        Board newBoard = new Board(); 
        newBoard.printBoard(); 


        ArrayList<Obstacle> toAdd = new ArrayList<Obstacle>();

        

        // 1 Rhino 
        Obstacle rhino = new Obstacle(); 
        ArrayList<Integer> coords1 = new ArrayList<Integer>(); 
        coords1.add(0); 
        coords1.add(0); 
        char aChar = 'R'; 
        rhino.insert(rhino, coords1, aChar);

        ArrayList<Integer> coords2 = new ArrayList<Integer>(); 
        coords2.add(0); 
        coords2.add(1);

        rhino.insert(rhino,coords2, aChar);

        toAdd.add(rhino); 
        // Rhino HEAD      @ (1,1)
        // Rhino BODY/TAIL @ (1,2)
        // ----------------------------------------------------
        //Obstacle linkedList, ArrayList<Integer> currentCoords, char animalChar

        newBoard.populate(toAdd);
        newBoard.update(); 
        newBoard.printBoard(); 

        // String to Obstacle list? TO be able to easily test & convert strings
        // from a .txt file for example into obstacles. 
        //      How do we format? 
        //          char x_coord y_coord length direction(up, down, left, right)
        //          R, 0,0,2,right
        //  -> DO THIS LATER, FIRST WE SETTLE MOVING! 


    }
}
