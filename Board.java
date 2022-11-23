
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Set;



public class Board {


    // final int BOARD_WIDTH  = 80; 
    // final int BOARD_HEIGHT = 80;

    final int GRID_WIDTH = 6;
    final int GRID_HEIGHT = 6; 

    //private char[][] boardValues; //= new char[GRID_WIDTH][GRID_HEIGHT]; 
    // Create a 2D array which will be later used to print, 
    // the entire board as well as create board states on game start

    
    ArrayList< ArrayList<Character> > boardState = new ArrayList< ArrayList<Character>>(); // Tracks actual boardstate for printing

    //ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>(); // Tracks all obstacles on the board
    // Even though we turn obstacles into characters, we can actual use these characters
    // for collision checking. This is because R and a Obstacle(R) are essentially the same thing. 
    // Wow what a genius idea Group 8, simplifying error checking into characters rather than having 
    // to iterate through linked lists. 

    //HashMap<String, String> capitalCities = new HashMap<String, String>();

    HashMap<Character, Obstacle> obstacleMap = new HashMap<Character, Obstacle>(); 
    // We keep track of these obstacles in a Hashmap. This is done because then
    // the user can just enter the character thats shown on the board and we can easily
    // extract the appropraite obstacle from the hashmap. Saves us the headache of iterating
    // throuhg the entire obstacleList we had before and finding the current Obstacle LL. 
    // ** ALSO HELPS ME DO MOVE CHECKING! SO IT WAS NECESSARY! 
    
    

    public Board(){
        for(int i = 0; i < GRID_WIDTH; i++){
            //ArrayList<Character> emptyList = new ArrayList<Character>
            this.boardState.add(new ArrayList<Character>());
            for(int j = 0; j < GRID_HEIGHT; j++){
                this.boardState.get(i).add(' ');
            }

        }
    }

    public Board(ArrayList<Obstacle> obstacles){
        for(int i = 0; i < GRID_WIDTH; i++){
            //ArrayList<Character> emptyList = new ArrayList<Character>
            this.boardState.add(new ArrayList<Character>());
            for(int j = 0; j < GRID_HEIGHT; j++){
                this.boardState.get(i).add(' ');
            }

        }

        this.populate(obstacles);
    }

    public void populate(ArrayList<Obstacle> obstacles){
        // This is supposed to populate the obstacleList
        // so we know what obstacles we are working with. 
        // Essentially turns an empty list of obstacles
        // into one filled with Obstacles. 
        // obstacleList.clear();
        // for(int i = 0; i < obstacles.size(); i++){
        //     obstacleList.add(obstacles.get(i));
        // }

        obstacleMap.clear();
        for(int i = 0; i < obstacles.size(); i++){
            obstacleMap.put(obstacles.get(i).header.animalChar, obstacles.get(i));
        }
    }

    public void update(){
        // Used to update the printing string. 
        // ** MUST BE DONE AFTER EVERY MOVE NO MATTER WHAT
        // OR OUR PRINTING AND ERROR CHECKING ARE GOING TO BE OFF
        // AND THE ENTIRE GAME IS GOING TO BREAK! UPDATE THE
        // DAMN BOARD!
    
        boardState.clear(); // -> First we clear the entire board

        // Fill board again with EMPTY BOXES
        for(int i = 0; i < GRID_WIDTH; i++){
            //ArrayList<Character> emptyList = new ArrayList<Character>
            this.boardState.add(new ArrayList<Character>());
            for(int j = 0; j < GRID_HEIGHT; j++){
                this.boardState.get(i).add(' ');
            }
        }

        Set<Character> obstKeys = obstacleMap.keySet(); 
        for(char x : obstKeys){
            Obstacle.Node curNode = obstacleMap.get(x).header; 
            

            while(curNode != null){
                boardState.get(curNode.currentCoords.get(0))
                    .set( curNode.currentCoords.get(1), curNode.getAnimalChar());

            
                curNode = curNode.next; 
            }
        }

    }

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

    public void printBoard(){
        // STILL ON THE DOCKET:
        //      1. Convert the print function to only print GRID_WIDTH number of boxes.
        //      It should already only print GRID_HEIGHT in terms of HEIGHT but WIDTH IS STILL NOT FIXED!
        //          -> A solution is to simply make a total lines string that would take the place of: 
        //              System.out.print("║   ║       ║       ║       ║       ║       ║       ║\n"); 
        //              and ALL OTHER STATIC PRINTING STRINGS IN THE FUNCTION!

        System.out.print("""
            ╔═══╦═══════╦═══════╦═══════╦═══════╦═══════╦═══════╗
            ║ 0 ║   1   ║   2   ║   3   ║   4   ║   5   ║   6   ║
            ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╣
                """);

        for(int i = 0; i < GRID_WIDTH; i++){
            System.out.print("║   ║       ║       ║       ║       ║       ║       ║\n");
            System.out.printf("║ %d ║",i+1);
            for(int j = 0; j < GRID_HEIGHT; j++){

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
            if(i < GRID_HEIGHT-1){
                System.out.print("""
                    ╠═══╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╣
                        """);
            }

        }

        System.out.println("╚═══╩═══════╩═══════╩═══════╩═══════╩═══════╩═══════╝");



    }


    public void moveObst(char obstChar, String dir){
        Obstacle obstToMove = obstacleMap.get(obstChar); 
        obstToMove.move(obstToMove, dir);
    }

    public boolean checkMove(char obstChar, String dir, int spaces){


        
        return false;
    }

    
}
