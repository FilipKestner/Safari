import java.util.ArrayList;
public class Obstacle {

   final int[] up= new int[]    { -1, 0};
   final int[] down= new int[]  { +1, 0};
   final int[] left= new int[]  {0,  -1};
   final int[] right= new int[] {0,  1};

   Node header;

       static class Node {
        // Node class for tracking each part of our animals. 
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
                //System.out.println(this.getCurrentCoords());
                this.currentCoords = newCoords;
                //System.out.println(this.getCurrentCoords());
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

       public Obstacle insert(Obstacle linkedList, ArrayList<Integer> currentCoords, char animalChar){

        Node new_node = new Node(currentCoords, null, animalChar); // Node to be added
        //Node prev_node;                       // Node right before new_node

        if(linkedList.header == null){
            linkedList.header = new_node;
        }
        else{
            Node cursor_node = linkedList.header; 

            while (cursor_node.next != null){
                cursor_node = cursor_node.next;
            }
            cursor_node.next = new_node; 
        }

        return linkedList; 
       }

       public void printList(Obstacle linkedList){
        // A function to be able to error check our Obstacle linked
        // lists in the future if a problem arises. Formatted to display
        // almost all relevent values. 
            Node cur_node = linkedList.header; 

            System.out.println(" Linked List: ");

            while(cur_node != null){
                System.out.printf("\t%c | (%d,%d)\n",cur_node.animalChar, cur_node.currentCoords.get(0), cur_node.currentCoords.get(1));
                cur_node = cur_node.next; 
            }

       }

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


        obst.printList(obst); 

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

        obst.printList(obst); 


       }


   }





