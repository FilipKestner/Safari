package be.kdg.integration1.team8.RushHour.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class tempMain {



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
        rhino.insert(rhino, 0,0, aChar);

        ArrayList<Integer> coords2 = new ArrayList<Integer>(); 
        coords2.add(0); 
        coords2.add(1);

        rhino.insert(rhino,0,1, aChar);


        toAdd.add(rhino); 
        // Rhino HEAD      @ (0,0)
        // Rhino BODY/TAIL @ (0,1)
        // ----------------------------------------------------
        //Obstacle linkedList, ArrayList<Integer> currentCoords, char animalChar

        // 2 Zebra
        // Note that we're reusing the same variables that we used in Rhino.
        // We're just overriding the values.
        Obstacle zebra = new Obstacle(); 
        aChar = 'Z'; 


        coords1 = new ArrayList<Integer>(); 
        coords1.add(2); 
        coords1.add(3); 
        zebra.insert(zebra, 2,3, aChar);

        coords1 = new ArrayList<Integer>(); 
        coords1.add(3); 
        coords1.add(3); 
        zebra.insert(zebra, 3,3, aChar);

        coords1 = new ArrayList<Integer>(); 
        coords1.add(4); 
        coords1.add(3); 
        zebra.insert(zebra, 4,3, aChar);


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

        // newBoard.moveObst('R',"right",1);
        // newBoard.update(); 
        // newBoard.printBoard();


        // newBoard.moveObst('R',"left",1);
        // newBoard.update(); 
        // newBoard.printBoard();


        // newBoard.moveObst('R',"down",1);
        // newBoard.update(); 
        // newBoard.printBoard();


        // newBoard.moveObst('R',"up",1);
        // newBoard.update(); 
        // newBoard.printBoard();

        // newBoard.moveObst('Z',"left",1);
        // newBoard.update(); 
        // newBoard.printBoard();


        newBoard.printObstacles();

        //System.out.println(newBoard.obstacleMap.get('Z').header.currentCoords);
        //System.out.println(newBoard.obstacleMap.get('Z').tail.currentCoords);

        

        newBoard.update();
        newBoard.printBoard();
        zebra.printList(); 

        System.out.println();
        System.out.println("checkMove Testing:");
        boolean check;

        System.out.println("MOVING R LEFT 1 OUT OF BOUNDS");
        check = newBoard.checkMove('R',"left",1);
        System.out.println(check);
        System.out.println("--------------------------\n");

        System.out.println("MOVING R RIGHT 3 VALID");
        check = newBoard.checkMove('R',"right",3);
        System.out.println(check);
        System.out.println("--------------------------\n");


        System.out.println("MOVING R DOWN 1 BAD DIRECTION");
        check = newBoard.checkMove('R',"down",1);
        System.out.println(check);
        System.out.println("--------------------------\n");

        System.out.println("MOVING R UP 1 BAD DIRECTION & OUT OF BOUNDS");
        check = newBoard.checkMove('R',"up",1);
        System.out.println(check);
        System.out.println("--------------------------\n");


        // ---------------------------------------------
        System.out.println("MOVING Z LEFT 3 OUT OF BOUNDS");
        check = newBoard.checkMove('Z',"left",3);
        System.out.println(check);
        System.out.println("--------------------------\n");

        System.out.println("MOVING Z RIGHT 1 VALID");
        check = newBoard.checkMove('Z',"right",1);
        System.out.println(check);
        System.out.println("--------------------------\n");

        System.out.println("MOVING Z LEFT 1 VALID");
        check = newBoard.checkMove('Z',"left",1);
        System.out.println(check);
        System.out.println("--------------------------\n");

        System.out.println("MOVING Z UP 1, INCORRECT ORIENTATION");
        check = newBoard.checkMove('Z',"up",1);
        System.out.println(check);
        System.out.println("--------------------------\n");

        System.out.println("MOVING Z DOWN 1, INCORRECT ORIENTATION");
        check = newBoard.checkMove('Z',"down",1);
        System.out.println(check);
        System.out.println("--------------------------\n");






        System.out.println("CHECKING AND THEN MOVING:");
        Scanner kb = new Scanner(System.in); 
        System.out.println("\tEnter a MOVE with the Following Format:");
        System.out.println("\t | ANIMAL_CHAR DIRECTION SPACES");
        System.out.println("\t | R right 3");
        String movement = kb.nextLine(); 

        //String[] splitMove = Arrays.asList(movement.split(" "));

        String[] splitMove = movement.split(" ");

        System.out.println(splitMove[0]);

        for(String x : splitMove){
            System.out.printf("%s | ",x);
        }
        System.out.println();

        // So now:
        //      splitMove[0] = animalChar
        //      splitMove[1] = dir
        //      splitMove[2] = spaces

        Obstacle toMove = newBoard.obstacleMap.get(splitMove[0].charAt(0)); 
        char anChar = splitMove[0].charAt(0);
        String direction = splitMove[1];
        int spaceCont = Integer.valueOf(splitMove[2]); // Converts string to int
        toMove.printList();
        if(newBoard.checkMove(anChar,direction,spaceCont)){

            System.out.println("VALID MOVE LETS MOVE IT!");
            newBoard.moveObst(anChar,direction,spaceCont); 
        }
        else{System.out.println("BAD MOVE DONT DO ANYTHING!");}

        toMove.printList(); 
        newBoard.update(); 
        newBoard.printBoard(); 
        

        newBoard.moveObst('R',"down",1);
        newBoard.update();
        newBoard.printBoard();

        newBoard.moveObst('R',"down",2);
        newBoard.update();
        newBoard.printBoard();


        newBoard.moveObst('Z',"left",1);
        newBoard.update();
        newBoard.printBoard();

    }
}
