package model;

import java.util.ArrayList;

public class Node {
        //ArrayList<Integer> currentCoords = new ArrayList<Integer>();

        int posX;
        int posY; 

        Node next;
        char animalChar;

        // public Node(ArrayList<Integer> currentCoords, Node nextLink, char animalChar) {
        //     setCurrentCoords(currentCoords);
        //     setNext(nextLink);
        //     setAnimalChar(animalChar);
        // }

        public Node(int x, int y, Node nextLink, char animalChar){
            setCurrentCoords(x, y);
            setNext(nextLink);
            setAnimalChar(animalChar);
        }

        public Node(char animalChar){
            setAnimalChar(animalChar);
        }

        // public ArrayList<Integer> getCurrentCoords() {
        // return currentCoords;
        // }
    
        // public void setCurrentCoords(ArrayList<Integer> newCoords) {
        //     this.currentCoords = new ArrayList<Integer>();
        //     this.currentCoords.add(newCoords.get(0));
        //     this.currentCoords.add(newCoords.get(1));
        // }

        public void setCurrentCoords(int x, int y){
            this.posX = x; 
            this.posY = y; 
        }

        public int getX(){
            return this.posX;
        }

        public int getY(){
            return this.posY; 
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
