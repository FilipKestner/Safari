package Safari;

public class Board {


    final int BOARD_WIDTH  = 80; 
    final int BOARD_HEIGHT = 80;

    final int GRID_WIDTH;
    final int GRID_HEIGHT; 

    private char[][] boardValues; //= new char[GRID_WIDTH][GRID_HEIGHT]; 
    // Create a 2D array which will be later used to print, 
    // the entire board as well as create board states on game start
    
    
    public Board(){
        this.GRID_HEIGHT = 6;
        this.GRID_WIDTH = 6; 


    }


    public Board(int width, int height){
        this.GRID_HEIGHT = height;
        this.GRID_WIDTH = width;
    }

    public void populate(){


    }

    public void populate(char[][] preset){

    
    }


    
}
