import java.util.ArrayList;

// Obstacle.java Write-Up
//      The Obstacle class is responsible for tracking obstacles which are 
//  eventually presented on the boardState of Board.java. It functions as a 
//  basic LINKED LIST.
//
//      ** RESOURCES EXPLAINING LINKED LISTS: 
//      **      https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
//
//  The Obstacle class tracks both the head (Node header) and tail (Node tail) of itself. 
//  this is for the sake of move checking and being able to automatically get the LEFT/RIGHT
//  or HIGHEST/LOWEST MOST NODES RELATIVE TO THE BOARD. This will become extremely useful in
//  the Board.checkMove() function later on. The Obstacle class is responsible for altering the 
//  coordinates of all the nodes under it and in turn responsible for movement across the board.
//  ** IT DOES NOT CHECK MOVEMENT ONLY PERFORM IT! CHECKING IS DONE BY Board.checkMove(). 
//
//      Important & Attributes, Their Purpose:
//              public static final int[] up= new int[]    { -1, 0}; } Reponsible for movement math to be able to 
//              public static final int[] down= new int[]  { +1, 0}; } change coordinates appropriately when moving
//              public static final int[] left= new int[]  { 0, -1}; } objects based on the direction given. 
//              public static final int[] right= new int[] { 0,  1}; } 
//
//              Node header -> Tracks the BEGINNING OF THE LINKED LIST
//              Node tail   -> Tracks the END OF THE LINKED LIST
//
public class Obstacle {

    // Why are they static? -> So I can call 
    // them without having to create an actual
    // obstacle
   public final int[] up= new int[]    { 0, -1};
   public final int[] down= new int[]  { 0, +1};
   public final int[] left= new int[]  { -1,  0};
   public final int[] right= new int[] { +1,  0};

   Node header;
   Node tail; 

    // Linked List Node, Refer to Linked List Tutorials to understand
    // it better. Also contains simple getters/setters. 
    static class Node {  
        ArrayList<Integer> currentCoords = new ArrayList<Integer>();
        Node next;
        char animalChar;

        public Node(ArrayList<Integer> currentCoords, Node nextLink, char animalChar) {
            setCurrentCoords(currentCoords);
            setNext(nextLink);
            setAnimalChar(animalChar);
        }

        public Node(char animalChar){
            setAnimalChar(animalChar);
        }

        public ArrayList<Integer> getCurrentCoords() {
        return currentCoords;
        }
    
        public void setCurrentCoords(ArrayList<Integer> newCoords) {
            this.currentCoords = new ArrayList<Integer>();
            this.currentCoords.add(newCoords.get(0));
            this.currentCoords.add(newCoords.get(1));
        }

        public Node getNext() {
            return next;
        }
    
        public void setNext(Node next) {
            this.next = next;
        }
    
        public char getAnimalChar() {
            return animalChar;
        }
    
        public void setAnimalChar(char animalChar) {
            this.animalChar = animalChar;
        }

    }


    // INSERT
    //      This function is how we actually create nodes in the linked list.
    //      it creates and inserts a new node to Obstacle based on the parameters given.
    //      NOTE, IT DOES NOT CHECK IF THE COORDINATES ARE CORRECT OR IF THE ANIMAL CHAR IS CORRECT!
    //      WE MUST ALWAYS GIVE OBSTACLE OBJECTS CURRENT INPUT! 
    public Obstacle insert(Obstacle linkedList, ArrayList<Integer> currentCoords, char animalChar){

    Node new_node = new Node(currentCoords, null, animalChar); 

        if(linkedList.header == null){
            linkedList.header = new_node;
            linkedList.tail = new_node; 
        }
        else{
            Node cursor_node = linkedList.header; 

            while (cursor_node.next != null){
                cursor_node = cursor_node.next;
            }
            cursor_node.next = new_node; 
            linkedList.tail = new_node;
        }
        return linkedList; 
    }

    // PRINT LIST
    //      Prints the entire obstacle list in a nicely formatted way. Used as a BUG FIXING
    //      TOOL AND NOTHING MORE! 
    public void printList(){
        // A function to be able to error check our Obstacle linked
        // lists in the future if a problem arises. Formatted to display
        // almost all relevent values. 

        // **** THIS PRINTS OUT IN NORMAL INDEX STARTING AT 1 NOT 0!!!!!!! *******
        // **** EVERYTHING IS STORED STARTING AT INDEX 0! BE WARE!!!!!!!!! *******
        Node cur_node = this.header; 

        System.out.printf(" Linked List: %c\n",cur_node.animalChar);

        while(cur_node != null){
            System.out.printf("\t%c | (%d,%d)\n",cur_node.animalChar, cur_node.currentCoords.get(0)+1, cur_node.currentCoords.get(1)+1);
            cur_node = cur_node.next; 
        }
    }

    // MOVE
    //      Initiates and completes the move for THE ENTIRE OBSTACLE LINKED LIST! IT DOES
    //      NOT CHECK IF THE MOVE CAN BE DONE OR NOT! Used by Board.java to actually
    //      move the objects when the player enters some input. Checking is done
    //      in Board.checkMove(). 
    public void move(Obstacle obst, String dir){
        // This should be the method that moves the coordinates
        // of the entire LL. DOES NOT PERFORM CHECKS! ONLY 
        // DOES THE CHANGING OF COORDS! CHECK SHOULD BE DONE
        // BY THE BOARD CLASS!!! 

        // Selecting the appropraite direction to move. 
        // Could also use case statement but this 
        // works and is more readble (at least for me)
        int[] moveCoords;
        if(dir.equals("up")){
            moveCoords = up; 
        }
        else if(dir.equals("down")){
            moveCoords = down; 
        }
        else if(dir.equals("left")){
            moveCoords = left;
        }
        else {//if(dir.toLowerCase().equals("right")){
            moveCoords = right;
        }


            

        Obstacle.Node curNode = obst.header; 
        
        ArrayList<Integer> newCoords = new ArrayList<Integer>(); 
        ArrayList<Integer> curCoords = new ArrayList<Integer>();


        

        while(curNode != null){
            curCoords = curNode.getCurrentCoords();
            newCoords.add( curCoords.get(0) + moveCoords[0]);
            newCoords.add( curCoords.get(1) + moveCoords[1]);

            curNode.setCurrentCoords(newCoords);

            // .clear() wasn't working so I had to 
            // reinstantiate the variables with 
            // empty array lists: 
            curCoords = new ArrayList<Integer>(); 
            newCoords = new ArrayList<Integer>(); 

            curNode = curNode.next; 
        }

    


    }


}





