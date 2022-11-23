import java.util.ArrayList;
public class Obstacle {

   final int[] up= new int[]    {+0, +1};
   final int[] down= new int[]  {+0, -1};
   final int[] left= new int[]  {-1, -0};
   final int[] right= new int[] {+1, -0};

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
     
            public void setCurrentCoords(ArrayList<Integer> currentCoords) {
                this.currentCoords = currentCoords;
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

       public static void printList(Obstacle linkedList){
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

       public static void move(Obstacle linkedList, char dir){
        // This should be the method that moves the coordinates
        // of one of our obstacles. will implement at end. 

       }


   }





