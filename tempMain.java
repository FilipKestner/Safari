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
        // Rhino HEAD      @ (0,0)
        // Rhino BODY/TAIL @ (0,1)
        // ----------------------------------------------------
        //Obstacle linkedList, ArrayList<Integer> currentCoords, char animalChar

        // 2 Zebra
        Obstacle zebra = new Obstacle(); 
        aChar = 'Z'; 


        coords1 = new ArrayList<Integer>(); 
        coords1.add(2); 
        coords1.add(3); 
        zebra.insert(zebra, coords1, aChar);

        coords1 = new ArrayList<Integer>(); 
        coords1.add(3); 
        coords1.add(3); 
        zebra.insert(zebra, coords1, aChar);

        coords1 = new ArrayList<Integer>(); 
        coords1.add(4); 
        coords1.add(3); 
        zebra.insert(zebra, coords1, aChar);


        toAdd.add(zebra);

        // ----------------------------------------------------



        newBoard.populate(toAdd);
        newBoard.update(); 
        newBoard.printBoard(); 

        // String to Obstacle list? TO be able to easily test & convert strings
        // from a .txt file for example into obstacles. 
        //      How do we format? 
        //          char x_coord y_coord length direction(up, down, left, right)
        //          R, 0,0,2,right
        //  -> DO THIS LATER, FIRST WE SETTLE MOVING! 

        newBoard.moveObst('R',"right",1);
        newBoard.update(); 
        newBoard.printBoard();


        newBoard.moveObst('R',"left",1);
        newBoard.update(); 
        newBoard.printBoard();


        newBoard.moveObst('R',"down",1);
        newBoard.update(); 
        newBoard.printBoard();


        newBoard.moveObst('R',"up",1);
        newBoard.update(); 
        newBoard.printBoard();

        // newBoard.moveObst('Z',"left",1);
        // newBoard.update(); 
        // newBoard.printBoard();


        newBoard.printObstacles();

        //System.out.println(newBoard.obstacleMap.get('Z').header.currentCoords);
        //System.out.println(newBoard.obstacleMap.get('Z').tail.currentCoords);

        newBoard.checkMove('R',"down",1);
        newBoard.checkMove('Z',"down",1);



    }
}
