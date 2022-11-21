///* **Write-Up** Obstacle
// The Obstacle object acts as a linked list. It has a header (some char) which then carries
// the rest of the nodes (body) with it.
//
// The four int[] arrays represent the changes the current coordinates (currentCoords) of an Obstacle
// can go through (going up would be an addition to the Y value, and no change to the X value).
//
//*/
//
//import java.util.ArrayList;
//public class Obstacle {
//
//    final int[] up= new int[]    {+0, +1};
//    final int[] down= new int[]  {+0, -1};
//    final int[] left= new int[]  {-1, -0};
//    final int[] right= new int[] {+1, -0};
//
//    public class Obstacle {
//
//        Node header;
//        static class Node {
//            ArrayList<Integer> currentCoords = new ArrayList<Integer>();
//            Obstacle next;
//            char animalChar;
//
//            public Node(ArrayList<Integer> currentCoords, ArrayList<Integer> nextCoords, char animalChar) {
//                setCurrentCoords(currentCoords);
//                setNextCoords(nextCoords);
//                setAnimalChar(animalChar);
//            }
//        }
//
//        public static Obstacle insert(Obstacle obst, char animalChar){
//            Node new_node = new Node(animalChar);
//
//            if (obst.header == null){      //if obstacle is empty
//                obst.header == new_node;   //make new obstacle-header
//            } else-if {                    //if not empty
//                Node last = obst.header;   //reference head of list
//                while (last.next != null){ //iterate through linked list
//                    last = last.next;      //check that var last is last node in Obstacle
//                }
//                last.next = new_node;
//            }
//            return obst;
//        }
//    }
//
//
//
//    public ArrayList<Integer> getCurrentCoords() {
//        return currentCoords;
//    }
//
//    public void setCurrentCoords(ArrayList<Integer> currentCoords) {
//        this.currentCoords = currentCoords;
//    }
//
//    public ArrayList<Integer> getNextCoords() {
//        return nextCoords;
//    }
//
//    public void setNextCoords(ArrayList<Integer> nextCoords) {
//        this.nextCoords = nextCoords;
//    }
//
//    public char getAnimalChar() {
//        return animalChar;
//    }
//
//    public void setAnimalChar(char animalChar) {
//        this.animalChar = animalChar;
//    }
//}
