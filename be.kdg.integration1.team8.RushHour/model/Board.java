package be.kdg.integration1.team8.RushHour.model;

import be.kdg.integration1.team8.RushHour.model.Obstacle;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Set;

// Board.java Write-Up:
//      The Board class is mainly responsible for tracking the current state of the
//  game board. It tracks the LOCATION of OBSTACLES (and as a result, PLAYER) as all
//  PRINTS board to player. The board acts as the LINKING LAYER between the player,
//  and all obstacles. It does this by also being responsible for checking if moves
//  are valid as well as initiating the appropriate coordinate changes in the Obstacle
//  class. 
//
//      Important & Attributes, Their Purpose:
//          ArrayList<ArrayList<Character> > boardState := responsible for tracking the board state via
//                                                         a 2D-ArrayList of characters. Each Obstacle
//                                                         node is represented as it's respective character.
//
//           HashMap<Character, Obstacle> obstacleMap := a DICTIONARY ('R' : Rhino Obstacle) which uses
//                                                       animal characters (Ex. 'R') as keys to refer to
//                                                       the Obstacle object responsible for said animal.
//                                                       This is extremely useful because we can easily 
//                                                       use a user input character 'Z' for example to instantly
//                                                       retrieve the Zebra object. Helps with move checking
//                                                       too. 
//
public class Board {


    // SIZE OF THE BOARD: 
    final int gridWidth = 6;
    final int gridHeight = 6; 
    // ------------------------
    // ** NOT IMPLEMENTED CORRECTLY 
    // IN THE PRINTING FUCNTION!
    // REVIEW AND CORRECT AT A LATER DATE ** 


    ArrayList<ArrayList<Character> > boardState = new ArrayList< ArrayList<Character>>(); // Tracks actual boardstate for printing
    //char[][] boardState2 = new char[][]();     
    HashMap<Character, Obstacle> obstacleMap = new HashMap<Character, Obstacle>();        // Dictionary of obstacles

    
    // Default Constructor with EMPTY OBSTACLE LIST
    public Board(){
        for(int i = 0; i < gridWidth; i++){
            this.boardState.add(new ArrayList<Character>());
            for(int j = 0; j < gridHeight; j++){
                this.boardState.get(i).add(' ');
            }

        }
    }

    // Constructor with OBSTACLE LIST
    public Board(ArrayList<Obstacle> obstacles){
        for(int i = 0; i < gridWidth; i++){
            this.boardState.add(new ArrayList<Character>());
            for(int j = 0; j < gridHeight; j++){
                this.boardState.get(i).add(' ');
            }
        }

        this.populate(obstacles);
    }


    
    // POPULATE 
    //      This function is used to take an ArrayList<Obstacle> and enter it 
    //      into the board object. This is what is used to essentially populate
    //      the board with Obstacles. 
    public void populate(ArrayList<Obstacle> obstacles){

        // 1. We must first clear the list to ensure we 
        // are working with an empty board.
        obstacleMap.clear(); 

        // 2. We loop through the obstacles ArrayList<Obstacle> that 
        // is a parameter, and insert every Obstacle INTO THE BOARD
        for(int i = 0; i < obstacles.size(); i++){
            obstacleMap.put(obstacles.get(i).header.animalChar, obstacles.get(i));
        }
    }
    // -------------------------------------------------------------------------------

    // UPDATE
    //      This function is the BREAD AND BUTTER OF THE ENTIRE BOARD CLASS! By 
    //      using this function and in turn not having to dynamically update
    //      boardState we make a number of tasks much simpler, easier as well
    //      as efficient. This function clears the entire boardState and repopulates
    //      it with the NEW COORDINATES OF THE OBSTACLES/PLAYER OBJECTS!
    //      **DISCLAIMER************************************* -> UPDATE THE DAMN BOARD
    //      ** THIS FUNCTION MUST BE RUN EVERY SINGLE LOOP **
    //      ** AND ANY TIME ANY MOVE OR CHANGE IS MADE TO  **
    //      ** THE OBSTACLE OR BOARD!                      **
    //      *************************************************
    public void update(){


        // 1. CLEAR the entire board to ensure we are working
        // with an empty board.
        boardState.clear(); 

        // 2. FILL the board with EMPTY BOXES to ensure that
        // we do not cause an OUT OF BOUNDS ERROR
        for(int i = 0; i < gridWidth; i++){
            //ArrayList<Character> emptyList = new ArrayList<Character>
            this.boardState.add(new ArrayList<Character>());
            for(int j = 0; j < gridHeight; j++){
                this.boardState.get(i).add(' ');
            }
        }

        

        // 3. Iterate through obstacleMap (:= The dictionary of all the obstacles
        // on the board), and CONVERT EVERY OBSTACLE INTO APPROPRIATE CHARACTERS 
        // ON THE BOARD (i.e. in ArrayList<ArrayList<Character> > boardState)
        Set<Character> obstKeys = obstacleMap.keySet(); // Get all keys in obstacleMap

        for(char x : obstKeys){ // For every ket in the dictionary
            Node curNode = obstacleMap.get(x).header; // Get the appropriate obstacle
        
            while(curNode != null){ // Iterate through the Obstacle LL
                boardState.get(curNode.getY())                        // Set Node(x,y) on boardState as
                    .set( curNode.getX(), curNode.getAnimalChar());   // the appropriate animal char.

            
                curNode = curNode.next; // Move on to next node in the Obstacle object.
            }
        }
    }
    // ---------------------------------------------------------------------------------------------------------------------

    

    // PRINT BOARD
    //       This function simply iterates through the entire 2D-ArrayList<ArrayList<Character>> and prints
    //       the characters with the appropriate formatting to look like a board.
    public void printBoard(){
        // STILL ON THE DOCKET:
        //      1. Convert the print function to only print gridWidth number of boxes.
        //      It should already only print gridHeight in terms of HEIGHT but WIDTH IS STILL NOT FIXED!
        //          -> A solution is to simply make a total lines string that would take the place of: 
        //              System.out.print("║   ║       ║       ║       ║       ║       ║       ║\n"); 
        //              and ALL OTHER STATIC PRINTING STRINGS IN THE FUNCTION!

        System.out.print("""
            ╔═══╦═══════╦═══════╦═══════╦═══════╦═══════╦═══════╗
            ║ 0 ║   1   ║   2   ║   3   ║   4   ║   5   ║   6   ║
            ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╣
                """);

        for(int i = 0; i < gridWidth; i++){
            System.out.print("║   ║       ║       ║       ║       ║       ║       ║\n");
            System.out.printf("║ %d ║",i+1);
            for(int j = 0; j < gridHeight; j++){

                if(boardState.get(i).get(j) != ' '){
                    System.out.printf("   %c   ║",boardState.get(i).get(j));
                }
                else{
                    System.out.print("       ║");
                }
            }
            System.out.print("\n");
            
            System.out.print("""
                ║   ║       ║       ║       ║       ║       ║       ║   
                    """);
            if(i < gridHeight-1){
                System.out.print("""
                    ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╣
                        """);
            }

        }

        System.out.println("╚═══╩═══════╩═══════╩═══════╩═══════╩═══════╩═══════╝");

    // Board Reference: 
    //     ╔═══╦═══════╦═══════╦═══════╦═══════╦═══════╦═══════╗
    //     ║ 0 ║   1   ║   2   ║   3   ║   4   ║   5   ║   6   ║
    //     ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╣
    //     ║   ║       ║       ║       ║       ║       ║       ║
    //     ║ 1 ║       ║       ║       ║       ║       ║       ║
    //     ║   ║       ║       ║       ║       ║       ║       ║
    //     ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╣
    //     ║   ║       ║       ║       ║       ║       ║       ║
    //     ║ 2 ║       ║       ║       ║       ║       ║       ║   
    //     ║   ║       ║       ║       ║       ║       ║       ║   
    //     ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╣
    //     ║   ║       ║       ║       ║       ║       ║       ║
    //     ║ 3 ║       ║       ║       ║       ║       ║       ║
    //     ║   ║       ║       ║       ║       ║       ║       ║   
    //     ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╣
    //     ║   ║       ║       ║       ║       ║       ║       ║
    //     ║ 4 ║       ║       ║       ║       ║       ║       ║
    //     ║   ║       ║       ║       ║       ║       ║       ║   
    //     ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╣═══════╣
    //     ║   ║       ║       ║       ║       ║       ║       ║
    //     ║ 5 ║       ║       ║       ║       ║       ║       ║ 
    //     ║   ║       ║       ║       ║       ║       ║       ║   
    //     ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╣═══════╣
    //     ║   ║       ║       ║       ║       ║       ║       ║
    //     ║ 6 ║       ║       ║       ║       ║       ║       ║
    //     ║   ║       ║       ║       ║       ║       ║       ║       
    //     ╚═══╩═══════╩═══════╩═══════╩═══════╩═══════╝═══════╝    

    }
    // ---------------------------------------------------------------------------------------------------------------------

    
    // PRINT OBSTACLES
    //      This function is INTENDED ONLY FOR TESTING PURPOSES! SERVES NO USE FOR GAMEPLAY!
    //      Prints all the obstacles that are currently SUPPOSED TO BE ON THE BOARD
    //      in a nicely foramtted list. 
    public void printObstacles(){
        // Prints all obstacles currently in the board. Function useful for error
        // checking and provides no gameplay functionality. 

        Set<Character> obstKeys = obstacleMap.keySet(); 
        for(char x : obstKeys){
            obstacleMap.get(x).printList();
        }
    }


    // MOVE OBSTACLE
    //      This function initiates the move function for the given obstacle.
    //      IT DOES NOT CHECK IF THE MOVE IS ALLOWED OR APPROPRIATE! THAT IS 
    //      HANDLED BY 'checkMove' function.
    public void moveObst(char obstChar, String dir, int spaces){
        Obstacle obstToMove = obstacleMap.get(obstChar);  // Get the Obstacle object

        for(int i = 0; i < spaces; i++){
            obstToMove.move(obstToMove, dir); //Call the move function for as many times as requested by spaces
        }

        //this.update(); 
    }

    public boolean checkMove(char obstChar, String dir, int spaces){
        // Get the obstacle object we want to move first
        Obstacle obst = obstacleMap.get(obstChar);

        // How do we tell if an obstacle is horizontal or vertical?
        // Well what comes to mind first is to check the difference
        // between header and header.next coordinates. Depending
        // on what the differnece is we know direction? 
        //
        // We could also just keep an 'H' or 'V' char telling us 
        // either VERTICAL or HORIZONTAL? 
        //
        // One other thing, we need to either:
        //      1. ASSUME THAT HEADER OF OBSTACLE IS ALWAYS ON EITHER
        //         THE LEFT MOST POINT OR TOP MOST POINT
        //
        //      2. Check based on head/tail depending on direction
        //
        //      BOTH???

        // New method, we check dir nad if same as current char we know
        // to go to the tail


        


        // 1. Check orientation of Obstacle:
        char obstOrientation; 
        //ArrayList<Integer> differenceCoords = new ArrayList<Integer>();
        int differenceX;
        int differenceY;

        // WE CAN ASSUME EVERY OBSTACLE IS AT LEAST 2 NODES LONG SO THIS
        // WILL ALWAYS WORK!
        // differenceCoords.add( obst.header.currentCoords.get(0) - obst.header.next.currentCoords.get(0));
        differenceX = obst.header.getX() - obst.header.next.getX(); 
        // differenceCoords.add( obst.header.currentCoords.get(1) - obst.header.next.currentCoords.get(1));
        differenceY = obst.header.getY() - obst.header.next.getY(); 

        

        if(differenceX == 0){obstOrientation = 'V';}
        else{obstOrientation = 'H';}

        //System.out.println(differenceCoords + " | " + obstChar + " | " + obstOrientation);



        // 2. Confirm the direction is appropriate
        //      -> Include ERROR CHECKING HERE LATER!



        //ArrayList<Integer> startingCoords = new ArrayList<Integer>();
        int startingX;
        int startingY;

        int[] movingCoords = new int[2]; 

        if(obstOrientation == 'H'){

            if(dir.equals("up") || dir.equals("down")){
                // INVALID COMMAND, TRYING TO MOVE HORIZONTAL PIECE UP OR DOWN
                return false;
            }

        // 3. Check to see if we should count from header or tail
        // and get the appropriate incremental coordinates
        
            // if HORIZONTAL, right->tail, left->head
            // if VERTICAL,   up->head, down->tail

            
            // ** BIG NOTE THAT WE CANT ACTUAL JUST SET startingCoords
            // AND THEN CHANGE THEM BECAUSE IT ACTUALLY AFFECTS 
            // THE COORDINATES! THIS IS BECAUSE WE DON'T PASS BY
            // VALUE WE ARE PASSING BY REFERENCE!! THEREFOR WE 
            // MUST EXTRACT THE VALUES USING .add()
            // up,   // -> { 0, -1}
            // down, // -> { 0, +1}
            // left, // -> { -1, 0}
            // right // -> { +1, 0}
            if(dir.equals("right")){ // Count from Tail

                //startingCoords.add(obst.tail.getCurrentCoords().get(0));
                startingX = obst.tail.getX();
                //startingCoords.add(obst.tail.getCurrentCoords().get(1));
                startingY = obst.tail.getY();
                //startingCoords = obst.tail.getCurrentCoords(); -> FAIL BECAUSE OF PASS BY REFERENECE
                //movingCoords = obst.right;
                movingCoords[0] = 1;
                movingCoords[1] = 0;
            }
            else{ // Count from Head
                // startingCoords = obst.header.getCurrentCoords(); 
                // startingCoords.add(obst.header.getCurrentCoords().get(0));
                // startingCoords.add(obst.header.getCurrentCoords().get(1));
                startingX = obst.header.getX(); 
                startingY = obst.header.getY(); 
                //movingCoords = obst.left;
                movingCoords[0] = -1;
                movingCoords[1] = 0;
            }

        }
        else if(obstOrientation == 'V'){
            if(dir.equals("left") || dir.equals("right")){
                // INVALID COMMAND, TRYING TO MOVE VERTICAL PIECE LEFT OR RIGHT
                return false;
            }


            if(dir.equals("down")){ // Count from Tail
                //startingCoords = obst.tail.getCurrentCoords(); 
                // startingCoords.add(obst.tail.getCurrentCoords().get(0));
                // startingCoords.add(obst.tail.getCurrentCoords().get(1));

                startingX = obst.tail.getX();
                startingY = obst.tail.getY();

                //movingCoords = obst.down;
                movingCoords[0] = 0;
                movingCoords[1] = 1;
            }
            else{ // Count from Head
                //startingCoords = obst.header.getCurrentCoords(); 
                // startingCoords.add(obst.header.getCurrentCoords().get(0));
                // startingCoords.add(obst.header.getCurrentCoords().get(1));
                startingX = obst.header.getX(); 
                startingY = obst.header.getY(); 

                //movingCoords = obst.up;
                movingCoords[0] = -1;
                movingCoords[1] = 0;
            }
        }
        else{
            System.out.println("Board.java, CHECK MOVE WENT WRONG IN OREINTATION CHECKING!");
            return false;
        }

       

        
        // Keep going in that direction and if there is something blocking
        // OR IT IS THE END OF THE BOARD we return false. If it finishes
        // the loop we RETURN true;
        for(int i = 0; i < spaces; i++){
            //startingCoords.set(0, startingCoords.get(0) + movingCoords[0]);
            startingX = startingX + movingCoords[0];
            //startingCoords.set(1, startingCoords.get(1) + movingCoords[1]);
            startingY = startingY + movingCoords[1];


            // Checks if we are still in range of the board
            if(startingX < 0 
                    || startingX > gridWidth-1
                    || startingY < 0 
                    || startingY > gridHeight-1){return false;}
            // Checks to make sure there is nothing already there
            //else if(boardState.get(startingCoords.get(0)).get(startingCoords.get(1)) != ' '){
            else if(boardState.get(startingX).get(startingY) != ' '){

                return false;
            }
        }

        

        return true;
 
    }

    
}
