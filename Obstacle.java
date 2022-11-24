import java.util.ArrayList;
public class Obstacle {

   final int[] up= new int[]    { -1, 0};
   final int[] down= new int[]  { +1, 0};
   final int[] left= new int[]  {0,  -1};
   final int[] right= new int[] {0,  1};

   Node header;
   Node tail; 
   //char direction; 
   // We dont NEED to implement 

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
                
                this.currentCoords = new ArrayList<Integer>();
                this.currentCoords.add(newCoords.get(0));
                this.currentCoords.add(newCoords.get(1));

                
                
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





